import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Creates the formatted university reports.
 */
public class ReportGenerator {

    public static class UniversityTotals {
        int numStudents = 0;
        int instate = 0;
        int outOfState = 0;

        int mealA = 0;
        int mealB = 0;
        int mealC = 0;

        double mealTotal = 0.0;
        double tuitionTotal = 0.0;
        double lateTotal = 0.0;
        double incidentalTotal = 0.0;
        double healthTotal = 0.0;

        double grandTotal() {
            return mealTotal + tuitionTotal + lateTotal + incidentalTotal + healthTotal;
        }
    }

    public static void writeAllUniversityReports(
            List<University> universities,
            List<Student> students,
            String outputFilePath,
            String unmatchedStudentsPath
    ) throws IOException {

        Map<String, University> uniByKey = new HashMap<>();
        for (University u : universities) {
            uniByKey.put(key(u.getUniversityName()), u);
        }

        // Group students by university name (case-insensitive).
        Map<String, List<Student>> studentsByUni = new HashMap<>();
        List<Student> unmatched = new ArrayList<>();

        for (Student s : students) {
            String k = key(s.getUniversityName());
            if (uniByKey.containsKey(k)) {
                studentsByUni.computeIfAbsent(k, kk -> new ArrayList<>()).add(s);
            } else {
                unmatched.add(s);
            }
        }

        // Sort student lists already sorted globally; keep as-is.

        try (PrintWriter out = new PrintWriter(new File(outputFilePath))) {
            for (University u : universities) {
                String k = key(u.getUniversityName());
                List<Student> uniStudents = studentsByUni.getOrDefault(k, Collections.emptyList());
                writeSingleUniversityReport(out, u, uniStudents);
                out.println();
                out.println();
            }
        }

        // Save unmatched students (if any) so nothing disappears silently.
        try (PrintWriter out = new PrintWriter(new File(unmatchedStudentsPath))) {
            out.println("Students whose university name did not match a University record:");
            out.println("firstname,middlename,lastname,age,gender,streetAddress,city,state,zip,phone,university,studentid,credits,instate,healthPlan,foodPlan,lateFees");
            for (Student s : unmatched) {
                out.println(s.toCSV());
            }
        }
    }

    private static void writeSingleUniversityReport(PrintWriter out, University u, List<Student> students) {
        final int WIDTH = 70;

        out.println();
        out.println(Util.center(u.getUniversityName().toUpperCase(), WIDTH));
        out.println(Util.center(u.getStreetAddress(), WIDTH));
        out.println(Util.center(u.getCity() + ", " + u.getState() + " " + u.getZip(), WIDTH));
        out.println(Util.center(Util.formatPhone(u.getPhoneNumber()), WIDTH));
        out.println();
        out.println();

        UniversityTotals totals = new UniversityTotals();

        for (Student s : students) {
            writeStudentSection(out, s, u, totals);
            out.println();
        }

        // Totals section
        out.println(Util.center(u.getUniversityName().toUpperCase() + " TOTALS", WIDTH));
        out.println();
        out.println("NUMBER OF STUDENTS\t" + totals.numStudents);
        out.println("INSTATE\t\t\t" + totals.instate);
        out.println("OUT OF STATE \t\t" + totals.outOfState);

        out.println("MEAL PLAN\t\t3 Meals a day\t\t" + totals.mealA + "\t" + Util.money(totals.mealA == 0 ? 0.0 : u.getStudentCostMealPlanA()).trim());
        out.println("\t\t\t2 Meals a day\t\t" + totals.mealB + "\t" + Util.money(totals.mealB == 0 ? 0.0 : u.getStudentCostMealPlanB()).trim());
        out.println("\t\t\t1 Meal a day\t\t" + totals.mealC + "\t" + Util.money(totals.mealC == 0 ? 0.0 : u.getStudentCostMealPlanC()).trim());
        out.println("\t\t\tFOOD SUB TOTAL\t\t" + Util.money(totals.mealTotal).trim());

        out.println("TUITION\t\t" + Util.money(totals.tuitionTotal).trim());
        out.println("LATE FEE\t\t" + Util.money(totals.lateTotal).trim());
        out.println("INCEDINTAL\t\t" + Util.money(totals.incidentalTotal).trim());
        out.println("HEALH CARE\t\t" + Util.money(totals.healthTotal).trim() + "\t\tTOTAL\t" + Util.money(totals.grandTotal()).trim());
    }

    private static void writeStudentSection(PrintWriter out, Student s, University u, UniversityTotals totals) {
        double tuition = BillingCalculator.tuition(s, u);
        double late = BillingCalculator.lateFee(s, u, tuition);
        double incidental = BillingCalculator.incidentalFee(s, u);
        double health = BillingCalculator.healthCare(s, u);
        double meal = BillingCalculator.mealPlan(s, u);

        double total = tuition + late + incidental + health + meal;

        totals.numStudents++;
        if (s.isQualifiesInState()) totals.instate++; else totals.outOfState++;

        char food = Character.toUpperCase(s.getFoodPlanChoice());
        if (food == 'A') totals.mealA++;
        else if (food == 'B') totals.mealB++;
        else if (food == 'C') totals.mealC++;

        totals.mealTotal += meal;
        totals.tuitionTotal += tuition;
        totals.lateTotal += late;
        totals.incidentalTotal += incidental;
        totals.healthTotal += health;

        out.println("NAME \t\t" + s.getName() + "\t\tCREDITS  \t" + s.getCreditsEnrolled());
        out.println("ADDRESS\t" + s.getStreetAddress() + ", " + s.getCity() + ", " + s.getState() + " " + s.getZip());
        out.println("PHONE\t\t" + Util.formatPhone(s.getPhoneNumber()));
        out.println();
        out.println("TUITION\t" + Util.money(tuition));
        out.println("LATE FEE\t" + Util.money(late));
        out.println("INCEDENTAL \t" + Util.money(incidental));
        out.println("HEALTH CARE " + Util.money(health));
        out.println("MEAL PLAN\t" + Util.money(meal) + "\t\t\t\t\tTOTAL \t\t" + Util.money(total));
    }

    private static String key(String s) {
        return s == null ? "" : s.trim().toLowerCase();
    }
}
