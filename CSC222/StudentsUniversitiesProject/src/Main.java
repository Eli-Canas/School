import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    /**
     * Main method for the program.
     * Defaults (when not provided):
     *   data/StudentFile.txt
     *   data/Universities9.txt
     *   output
     */
    public static void main(String[] args) {
        String studentsPath = args.length > 0 ? args[0] : "data/StudentFile.txt";
        String universitiesPath = args.length > 1 ? args[1] : "data/Universities9.txt";
        String outputDir = args.length > 2 ? args[2] : "output";

        try {
            new File(outputDir).mkdirs();

            ArrayList<Student> students = DataLoader.readStudents(studentsPath);
            ArrayList<University> universities = DataLoader.readUniversities(universitiesPath);

            // Sort using Bubble Sort and Comparable.
            BubbleSort.bubbleSort(students);
            BubbleSort.bubbleSort(universities);

            // Remove duplicates (after sorting)
            students = removeStudentDuplicates(students);
            universities = removeUniversityDuplicates(universities);

            // Output "object-based" text files (CSV built from objects)
            writeStudentsCSV(students, outputDir + File.separator + "StudentsOutput.csv");
            writeUniversitiesCSV(universities, outputDir + File.separator + "UniversitiesOutput.csv");

            // Formatted reports
            ReportGenerator.writeAllUniversityReports(
                    universities, students,
                    outputDir + File.separator + "UniversityReports.txt",
                    outputDir + File.separator + "UnmatchedStudents.csv"
            );

            // Binary files
            Serializer.writeStudents(outputDir + File.separator + "Students.dat", students);
            Serializer.writeUniversities(outputDir + File.separator + "Universities.dat", universities);

            System.out.println("Done. Outputs written to: " + outputDir);

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static ArrayList<Student> removeStudentDuplicates(ArrayList<Student> sorted) {
        ArrayList<Student> out = new ArrayList<>();
        Student prev = null;
        for (Student s : sorted) {
            if (prev == null || !s.equals(prev)) {
                out.add(s);
                prev = s;
            }
        }
        return out;
    }

    private static ArrayList<University> removeUniversityDuplicates(ArrayList<University> sorted) {
        ArrayList<University> out = new ArrayList<>();
        University prev = null;
        for (University u : sorted) {
            if (prev == null || !u.equals(prev)) {
                out.add(u);
                prev = u;
            }
        }
        return out;
    }

    private static void writeStudentsCSV(ArrayList<Student> students, String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new File(path))) {
            out.println("firstname,middlename,lastname,age,gender,streetAddress,city,state,zip,phone,university,studentid,credits,instate,healthPlan,foodPlan,lateFees");
            for (Student s : students) {
                out.println(s.toCSV());
            }
        }
    }

    private static void writeUniversitiesCSV(ArrayList<University> universities, String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new File(path))) {
            out.println("universityName,streetAddress,cityAddress,stateAddress,ZIPAddress,phoneNumber," +
                    "instateTuition1To11,instateTuition12To18,instateTuitionOver18," +
                    "outOfStateTuition1T011,outOfStateTuition12To18,outOfStateTuitionOver18," +
                    "studentCostMealPlanA,studentCostMealPlanB,studentCostMealPlanC," +
                    "healthCare1To10,healthCare11To15,healthCareOver15," +
                    "lateFeeRate,incedentalFeeRate,incedentalFeeMax");
            for (University u : universities) {
                out.println(u.toCSV());
            }
        }
    }
}
