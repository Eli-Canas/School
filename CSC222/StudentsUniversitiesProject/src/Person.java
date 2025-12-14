import java.io.Serializable;

/**
 * Person uses an immutable Name field and immutable Gender field.
 * compareTo precedence: Name, age, gender (F precedes M).
 */
public class Person implements Comparable<Person>, Serializable {
    private static final long serialVersionUID = 1L;

    private final Name name;
    private int age;
    private final char gender; // 'F' for female, 'M' for male

    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public Person(Name name, int age, char gender,
                  String streetAddress, String city, String state, String zip, String phoneNumber) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        this.name = name;
        this.age = age;
        this.gender = Character.toUpperCase(gender);
        this.streetAddress = safe(streetAddress);
        this.city = safe(city);
        this.state = safe(state);
        this.zip = safe(zip);
        this.phoneNumber = safe(phoneNumber);
    }

    protected static String safe(String s) {
        return s == null ? "" : s.trim();
    }

    public Name getName() { return name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public char getGender() { return gender; }

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

    
    public boolean equals(Person other) {
        if (other == null) return false;
        return name.equals(other.name)
                && age == other.age
                && Character.toUpperCase(gender) == Character.toUpperCase(other.gender)
                && streetAddress.equalsIgnoreCase(other.streetAddress)
                && city.equalsIgnoreCase(other.city)
                && state.equalsIgnoreCase(other.state)
                && zip.equalsIgnoreCase(other.zip)
                && phoneNumber.equalsIgnoreCase(other.phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        return equals((Person) obj);
    }

    @Override
    public int hashCode() {
        return (name.hashCode() + "|" + age + "|" + Character.toUpperCase(gender) + "|" +
                streetAddress.toLowerCase() + "|" + city.toLowerCase() + "|" + state.toLowerCase() + "|" +
                zip.toLowerCase() + "|" + phoneNumber).hashCode();
    }

    @Override
    public int compareTo(Person other) {
        if (other == null) return 1;

        int c = name.compareTo(other.name);
        if (c != 0) return c;

        if (age < other.age) return -1;
        if (age > other.age) return 1;

        // For gender, female precedes male.
        int g1 = genderRank(gender);
        int g2 = genderRank(other.gender);
        if (g1 < g2) return -1;
        if (g1 > g2) return 1;

        return 0;
    }

    private static int genderRank(char g) {
        char u = Character.toUpperCase(g);
        if (u == 'F') return 0;
        if (u == 'M') return 1;
        return 2; // unknown goes last
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                ", gender=" + gender +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
