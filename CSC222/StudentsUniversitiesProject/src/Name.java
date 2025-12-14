import java.io.Serializable;

/**
 * Immutable Name class.
 * Order of precedence for compareTo: last name, first name, middle name.
 */
public class Name implements Comparable<Name>, Serializable {
    private static final long serialVersionUID = 1L;

    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = safe(firstName);
        this.middleName = safe(middleName);
        this.lastName = safe(lastName);
    }

    private static String safe(String s) {
        return s == null ? "" : s.trim();
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }

    
    public boolean equals(Name other) {
        if (other == null) return false;
        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        return equals((Name) obj);
    }

    @Override
    public int hashCode() {
        return (lastName.toLowerCase() + "|" + firstName.toLowerCase() + "|" + middleName.toLowerCase()).hashCode();
    }

    @Override
    public String toString() {
        // Always include all parts; if middle is empty, it will just be extra space trimmed.
        String full = (firstName + " " + middleName + " " + lastName).trim();
        // collapse multiple spaces
        return full.replaceAll("\\s+", " ");
    }

    @Override
    public int compareTo(Name other) {
        if (other == null) return 1;
        int c = cmp(lastName, other.lastName);
        if (c != 0) return c;
        c = cmp(firstName, other.firstName);
        if (c != 0) return c;
        c = cmp(middleName, other.middleName);
        return c;
    }

    private static int cmp(String a, String b) {
        int r = safe(a).compareToIgnoreCase(safe(b));
        if (r < 0) return -1;
        if (r > 0) return 1;
        return 0;
    }
}
