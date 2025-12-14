import java.io.Serializable;

/**
 * University object holding rates and contact info.
 * Natural order: University name, State, City.
 */
public class University implements Comparable<University>, Serializable {
    private static final long serialVersionUID = 1L;

    private String universityName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    // Tuition per credit
    private double instateTuition1To11;
    private double instateTuition12To18;
    private double instateTuitionOver18;

    private double outOfStateTuition1To11;
    private double outOfStateTuition12To18;
    private double outOfStateTuitionOver18;

    // Optional costs
    private double studentCostMealPlanA;
    private double studentCostMealPlanB;
    private double studentCostMealPlanC;

    private double healthCare1To10;
    private double healthCare11To15;
    private double healthCareOver15;

    // Fees
    private double lateFeeRate;        // rate applied to tuition if late
    private double incidentalFeeRate;  // per credit
    private double incidentalFeeMax;   // maximum

    public University(String universityName, String streetAddress, String city, String state, String zip, String phoneNumber,
                      double instateTuition1To11, double instateTuition12To18, double instateTuitionOver18,
                      double outOfStateTuition1To11, double outOfStateTuition12To18, double outOfStateTuitionOver18,
                      double studentCostMealPlanA, double studentCostMealPlanB, double studentCostMealPlanC,
                      double healthCare1To10, double healthCare11To15, double healthCareOver15,
                      double lateFeeRate, double incidentalFeeRate, double incidentalFeeMax) {

        this.universityName = safe(universityName);
        this.streetAddress = safe(streetAddress);
        this.city = safe(city);
        this.state = safe(state);
        this.zip = safe(zip);
        this.phoneNumber = safe(phoneNumber);

        this.instateTuition1To11 = instateTuition1To11;
        this.instateTuition12To18 = instateTuition12To18;
        this.instateTuitionOver18 = instateTuitionOver18;

        this.outOfStateTuition1To11 = outOfStateTuition1To11;
        this.outOfStateTuition12To18 = outOfStateTuition12To18;
        this.outOfStateTuitionOver18 = outOfStateTuitionOver18;

        this.studentCostMealPlanA = studentCostMealPlanA;
        this.studentCostMealPlanB = studentCostMealPlanB;
        this.studentCostMealPlanC = studentCostMealPlanC;

        this.healthCare1To10 = healthCare1To10;
        this.healthCare11To15 = healthCare11To15;
        this.healthCareOver15 = healthCareOver15;

        this.lateFeeRate = lateFeeRate;
        this.incidentalFeeRate = incidentalFeeRate;
        this.incidentalFeeMax = incidentalFeeMax;
    }

    private static String safe(String s) { return s == null ? "" : s.trim(); }

    public String getUniversityName() { return universityName; }
    public void setUniversityName(String universityName) { this.universityName = safe(universityName); }

    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = safe(streetAddress); }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = safe(city); }

    public String getState() { return state; }
    public void setState(String state) { this.state = safe(state); }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = safe(zip); }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = safe(phoneNumber); }

    public double getInstateTuition1To11() { return instateTuition1To11; }
    public void setInstateTuition1To11(double v) { this.instateTuition1To11 = v; }

    public double getInstateTuition12To18() { return instateTuition12To18; }
    public void setInstateTuition12To18(double v) { this.instateTuition12To18 = v; }

    public double getInstateTuitionOver18() { return instateTuitionOver18; }
    public void setInstateTuitionOver18(double v) { this.instateTuitionOver18 = v; }

    public double getOutOfStateTuition1To11() { return outOfStateTuition1To11; }
    public void setOutOfStateTuition1To11(double v) { this.outOfStateTuition1To11 = v; }

    public double getOutOfStateTuition12To18() { return outOfStateTuition12To18; }
    public void setOutOfStateTuition12To18(double v) { this.outOfStateTuition12To18 = v; }

    public double getOutOfStateTuitionOver18() { return outOfStateTuitionOver18; }
    public void setOutOfStateTuitionOver18(double v) { this.outOfStateTuitionOver18 = v; }

    public double getStudentCostMealPlanA() { return studentCostMealPlanA; }
    public void setStudentCostMealPlanA(double v) { this.studentCostMealPlanA = v; }

    public double getStudentCostMealPlanB() { return studentCostMealPlanB; }
    public void setStudentCostMealPlanB(double v) { this.studentCostMealPlanB = v; }

    public double getStudentCostMealPlanC() { return studentCostMealPlanC; }
    public void setStudentCostMealPlanC(double v) { this.studentCostMealPlanC = v; }

    public double getHealthCare1To10() { return healthCare1To10; }
    public void setHealthCare1To10(double v) { this.healthCare1To10 = v; }

    public double getHealthCare11To15() { return healthCare11To15; }
    public void setHealthCare11To15(double v) { this.healthCare11To15 = v; }

    public double getHealthCareOver15() { return healthCareOver15; }
    public void setHealthCareOver15(double v) { this.healthCareOver15 = v; }

    public double getLateFeeRate() { return lateFeeRate; }
    public void setLateFeeRate(double v) { this.lateFeeRate = v; }

    public double getIncidentalFeeRate() { return incidentalFeeRate; }
    public void setIncidentalFeeRate(double v) { this.incidentalFeeRate = v; }

    public double getIncidentalFeeMax() { return incidentalFeeMax; }
    public void setIncidentalFeeMax(double v) { this.incidentalFeeMax = v; }

    /** CSV for output file. */
    public String toCSV() {
        return String.join(",",
                universityName,
                streetAddress,
                city,
                state,
                zip,
                phoneNumber,
                fmt(instateTuition1To11),
                fmt(instateTuition12To18),
                fmt(instateTuitionOver18),
                fmt(outOfStateTuition1To11),
                fmt(outOfStateTuition12To18),
                fmt(outOfStateTuitionOver18),
                fmt(studentCostMealPlanA),
                fmt(studentCostMealPlanB),
                fmt(studentCostMealPlanC),
                fmt(healthCare1To10),
                fmt(healthCare11To15),
                fmt(healthCareOver15),
                fmt(lateFeeRate),
                fmt(incidentalFeeRate),
                fmt(incidentalFeeMax)
        );
    }

    private static String fmt(double d) {
        return String.format(java.util.Locale.US, "%.2f", d);
    }

    @Override
    public int compareTo(University other) {
        if (other == null) return 1;
        int c = cmp(universityName, other.universityName);
        if (c != 0) return c;
        c = cmp(state, other.state);
        if (c != 0) return c;
        return cmp(city, other.city);
    }

    private static int cmp(String a, String b) {
        int r = safe(a).compareToIgnoreCase(safe(b));
        if (r < 0) return -1;
        if (r > 0) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof University)) return false;
        University o = (University) obj;
        // Treat as duplicate only if every field matches (safe for "remove duplicates" pass).
        return universityName.equalsIgnoreCase(o.universityName)
                && streetAddress.equalsIgnoreCase(o.streetAddress)
                && city.equalsIgnoreCase(o.city)
                && state.equalsIgnoreCase(o.state)
                && zip.equalsIgnoreCase(o.zip)
                && phoneNumber.equalsIgnoreCase(o.phoneNumber)
                && Double.compare(instateTuition1To11, o.instateTuition1To11) == 0
                && Double.compare(instateTuition12To18, o.instateTuition12To18) == 0
                && Double.compare(instateTuitionOver18, o.instateTuitionOver18) == 0
                && Double.compare(outOfStateTuition1To11, o.outOfStateTuition1To11) == 0
                && Double.compare(outOfStateTuition12To18, o.outOfStateTuition12To18) == 0
                && Double.compare(outOfStateTuitionOver18, o.outOfStateTuitionOver18) == 0
                && Double.compare(studentCostMealPlanA, o.studentCostMealPlanA) == 0
                && Double.compare(studentCostMealPlanB, o.studentCostMealPlanB) == 0
                && Double.compare(studentCostMealPlanC, o.studentCostMealPlanC) == 0
                && Double.compare(healthCare1To10, o.healthCare1To10) == 0
                && Double.compare(healthCare11To15, o.healthCare11To15) == 0
                && Double.compare(healthCareOver15, o.healthCareOver15) == 0
                && Double.compare(lateFeeRate, o.lateFeeRate) == 0
                && Double.compare(incidentalFeeRate, o.incidentalFeeRate) == 0
                && Double.compare(incidentalFeeMax, o.incidentalFeeMax) == 0;
    }

    @Override
    public int hashCode() {
        return (universityName.toLowerCase() + "|" + state.toLowerCase() + "|" + city.toLowerCase() + "|" + zip).hashCode();
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
