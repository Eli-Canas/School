/**
 * Computes student bill items based on the University rates and student selections.
 */
public class BillingCalculator {

    public static double tuition(Student s, University u) {
        int credits = Math.max(0, s.getCreditsEnrolled());
        boolean instate = s.isQualifiesInState();

        double rate;
        if (credits <= 11) {
            rate = instate ? u.getInstateTuition1To11() : u.getOutOfStateTuition1To11();
        } else if (credits <= 18) {
            rate = instate ? u.getInstateTuition12To18() : u.getOutOfStateTuition12To18();
        } else {
            rate = instate ? u.getInstateTuitionOver18() : u.getOutOfStateTuitionOver18();
        }
        return credits * rate;
    }

    public static double lateFee(Student s, University u, double tuition) {
        if (!s.isLateFeesAssessed()) return 0.0;
        return tuition * u.getLateFeeRate();
    }

    public static double incidentalFee(Student s, University u) {
        int credits = Math.max(0, s.getCreditsEnrolled());
        double fee = credits * u.getIncidentalFeeRate();
        return Math.min(fee, u.getIncidentalFeeMax());
    }

    public static double healthCare(Student s, University u) {
        if (!s.hasHealthPlan()) return 0.0;
        int credits = Math.max(0, s.getCreditsEnrolled());

        int first10 = Math.min(credits, 10);
        int next5 = Math.max(Math.min(credits, 15) - 10, 0);
        int over15 = Math.max(credits - 15, 0);

        return first10 * u.getHealthCare1To10()
                + next5 * u.getHealthCare11To15()
                + over15 * u.getHealthCareOver15();
    }

    public static double mealPlan(Student s, University u) {
        char plan = Character.toUpperCase(s.getFoodPlanChoice());
        switch (plan) {
            case 'A': return u.getStudentCostMealPlanA();
            case 'B': return u.getStudentCostMealPlanB();
            case 'C': return u.getStudentCostMealPlanC();
            default: return 0.0; // D or unknown
        }
    }
}
