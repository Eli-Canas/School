import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads the CSV-like input files.
 * Both files may begin with a single integer line indicating record count; we ignore it if present.
 */
public class DataLoader {

    public static ArrayList<Student> readStudents(String path) throws IOException {
        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            if (line == null) return students;

            // If first line is a count, skip it.
            if (!line.trim().contains(",") && line.trim().matches("\\d+")) {
                line = br.readLine();
            }

            while (line != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    Student s = parseStudent(line);
                    if (s != null) students.add(s);
                }
                line = br.readLine();
            }
        }

        return students;
    }

    private static Student parseStudent(String line) {
        String[] p = line.split(",", -1);
        // Expected 17 fields per SandUFileFormats
        if (p.length < 17) return null;

        String first = p[0].trim();
        String middle = p[1].trim();
        String last = p[2].trim();
        int age = parseInt(p[3], 0);
        char gender = charAt(p[4], 'U');

        String street = p[5].trim();
        String city = p[6].trim();
        String state = p[7].trim();
        String zip = p[8].trim();
        String phone = p[9].trim();

        String uni = p[10].trim();
        String studentId = p[11].trim();
        int credits = parseInt(p[12], 0);

        boolean instate = yn(p[13]);
        boolean health = yn(p[14]);
        char food = charAt(p[15], 'D');
        boolean late = yn(p[16]);

        Name name = new Name(first, middle, last);
        return new Student(name, age, gender, street, city, state, zip, phone, uni, studentId, credits, instate, health, food, late);
    }

    public static ArrayList<University> readUniversities(String path) throws IOException {
        ArrayList<University> universities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            if (line == null) return universities;

            // If first line is a count, skip it.
            if (!line.trim().contains(",") && line.trim().matches("\\d+")) {
                line = br.readLine();
            }

            while (line != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    University u = parseUniversity(line);
                    if (u != null) universities.add(u);
                }
                line = br.readLine();
            }
        }

        return universities;
    }

    private static University parseUniversity(String line) {
        String[] p = line.split(",", -1);
        // Expected 21 fields per SandUFileFormats.txt
        if (p.length < 21) return null;

        String name = p[0].trim();
        String street = p[1].trim();
        String city = p[2].trim();
        String state = p[3].trim();
        String zip = p[4].trim();
        String phone = p[5].trim();

        double in1 = parseDouble(p[6], 0);
        double in2 = parseDouble(p[7], 0);
        double in3 = parseDouble(p[8], 0);

        double out1 = parseDouble(p[9], 0);
        double out2 = parseDouble(p[10], 0);
        double out3 = parseDouble(p[11], 0);

        double mealA = parseDouble(p[12], 0);
        double mealB = parseDouble(p[13], 0);
        double mealC = parseDouble(p[14], 0);

        double hc1 = parseDouble(p[15], 0);
        double hc2 = parseDouble(p[16], 0);
        double hc3 = parseDouble(p[17], 0);

        double lateRate = parseDouble(p[18], 0);
        double incRate = parseDouble(p[19], 0);
        double incMax = parseDouble(p[20], 0);

        return new University(name, street, city, state, zip, phone,
                in1, in2, in3,
                out1, out2, out3,
                mealA, mealB, mealC,
                hc1, hc2, hc3,
                lateRate, incRate, incMax);
    }

    private static int parseInt(String s, int fallback) {
        try { return Integer.parseInt(s.trim()); }
        catch (Exception e) { return fallback; }
    }

    private static double parseDouble(String s, double fallback) {
        try { return Double.parseDouble(s.trim()); }
        catch (Exception e) { return fallback; }
    }

    private static boolean yn(String s) {
        if (s == null) return false;
        return s.trim().equalsIgnoreCase("Y") || s.trim().equalsIgnoreCase("YES") || s.trim().equalsIgnoreCase("TRUE");
    }

    private static char charAt(String s, char fallback) {
        if (s == null) return fallback;
        s = s.trim();
        if (s.isEmpty()) return fallback;
        return s.charAt(0);
    }
}
