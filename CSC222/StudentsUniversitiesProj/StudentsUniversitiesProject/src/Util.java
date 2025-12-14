import java.text.DecimalFormat;

public class Util {
    private static final DecimalFormat MONEY = new DecimalFormat("#,##0.00");

    public static String money(double value) {
        return "$ " + padLeft(MONEY.format(value), 10);
    }

    public static String padLeft(String s, int width) {
        if (s == null) s = "";
        if (s.length() >= width) return s;
        return " ".repeat(width - s.length()) + s;
    }

    public static String formatPhone(String digits) {
        if (digits == null) return "";
        String d = digits.replaceAll("\\D", "");
        if (d.length() == 10) {
            return String.format("(%s) %s-%s", d.substring(0,3), d.substring(3,6), d.substring(6));
        }
        return digits.trim(); // fallback
    }

    public static String center(String text, int width) {
        if (text == null) text = "";
        text = text.trim();
        if (text.length() >= width) return text;
        int pad = (width - text.length()) / 2;
        return " ".repeat(pad) + text;
    }

    public static String sanitizeFileName(String s) {
        if (s == null) return "unknown";
        return s.trim().replaceAll("[^A-Za-z0-9._-]+", "_");
    }
}
