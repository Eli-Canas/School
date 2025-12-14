import java.io.Serializable;

/**
 * Student extends Person.
 * compareTo precedence: Person, then studentId.
 * equals(Student): true if Name and studentId are equal.
 *
 * Input file order (per SandUFileFormats.txt):
 * first,middle,last,age,gender,street,city,state,zip,phone,university,studentId,credits,instate,healthPlan,foodPlan,lateFees
 */
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String studentId; // immutable
    private String universityName;
    private int creditsEnrolled;
    private boolean qualifiesInState;
    private boolean lateFeesAssessed;
    private char foodPlanChoice; // A, B, C, D
    private boolean healthPlan;

    public Student(Name name, int age, char gender,
                   String streetAddress, String city, String state, String zip, String phoneNumber,
                   String universityName, String studentId, int creditsEnrolled,
                   boolean qualifiesInState, boolean healthPlan, char foodPlanChoice, boolean lateFeesAssessed) {

        super(name, age, gender, streetAddress, city, state, zip, phoneNumber);
        this.universityName = safe(universityName);
        this.studentId = safe(studentId);
        this.creditsEnrolled = creditsEnrolled;
        this.qualifiesInState = qualifiesInState;
        this.healthPlan = healthPlan;
        this.foodPlanChoice = Character.toUpperCase(foodPlanChoice);
        this.lateFeesAssessed = lateFeesAssessed;
    }

    public String getStudentId() { return studentId; }

    public String getUniversityName() { return universityName; }
    public void setUniversityName(String universityName) { this.universityName = safe(universityName); }

    public int getCreditsEnrolled() { return creditsEnrolled; }
    public void setCreditsEnrolled(int creditsEnrolled) { this.creditsEnrolled = creditsEnrolled; }

    public boolean isQualifiesInState() { return qualifiesInState; }
    public void setQualifiesInState(boolean qualifiesInState) { this.qualifiesInState = qualifiesInState; }

    public boolean isLateFeesAssessed() { return lateFeesAssessed; }
    public void setLateFeesAssessed(boolean lateFeesAssessed) { this.lateFeesAssessed = lateFeesAssessed; }

    public char getFoodPlanChoice() { return foodPlanChoice; }
    public void setFoodPlanChoice(char foodPlanChoice) { this.foodPlanChoice = Character.toUpperCase(foodPlanChoice); }

    public boolean hasHealthPlan() { return healthPlan; }
    public void setHealthPlan(boolean healthPlan) { this.healthPlan = healthPlan; }

    
    public boolean equals(Student other) {
        if (other == null) return false;
        return getName().equals(other.getName()) && studentId.equalsIgnoreCase(other.studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        return equals((Student) obj);
    }

    @Override
    public int hashCode() {
        return (getName().hashCode() + "|" + studentId.toLowerCase()).hashCode();
    }

    /**
     * Student compareTo is called from a sorted collection, so we need to handle nulls.
     * If both objects are Students and Person parts are equal, we break ties with Student ID.
     */
    @Override
    public int compareTo(Person other) {
        if (other == null) return 1;

        int c = super.compareTo(other);
        if (c != 0) return c;

        if (other instanceof Student) {
            Student o = (Student) other;
            c = safe(studentId).compareToIgnoreCase(safe(o.studentId));
            if (c < 0) return -1;
            if (c > 0) return 1;
        }
        return 0;
    }

    /** CSV for output file. */
    public String toCSV() {
        return String.join(",",
                csv(getName().getFirstName()),
                csv(getName().getMiddleName()),
                csv(getName().getLastName()),
                String.valueOf(getAge()),
                String.valueOf(getGender()),
                csv(getStreetAddress()),
                csv(getCity()),
                csv(getState()),
                csv(getZip()),
                csv(getPhoneNumber()),
                csv(getUniversityName()),
                csv(getStudentId()),
                String.valueOf(getCreditsEnrolled()),
                boolYN(isQualifiesInState()),
                boolYN(hasHealthPlan()),
                String.valueOf(getFoodPlanChoice()),
                boolYN(isLateFeesAssessed())
        );
    }

    private static String csv(String s) {
        return s == null ? "" : s.trim();
    }

    private static String boolYN(boolean b) { return b ? "Y" : "N"; }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + getName() +
                ", id='" + studentId + '\'' +
                ", university='" + universityName + '\'' +
                ", credits=" + creditsEnrolled +
                ", instate=" + qualifiesInState +
                ", healthPlan=" + healthPlan +
                ", foodPlan=" + foodPlanChoice +
                ", lateFees=" + lateFeesAssessed +
                '}';
    }
}
