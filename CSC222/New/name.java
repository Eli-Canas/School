package New;
import java.util.Random;

public class Name {
    // Private instance variables
    private String firstName;
    private String middleName;
    private String lastName;

    // Constructor that initializes a new Name object with random first, middle, and last names
    public Name() {
        this.firstName = getRandomName();
        this.middleName = getRandomName();
        this.lastName = getRandomName();
    }

    // Constructor that initializes a new Name object with the values of the arguments
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Returns the first name
    public String getFirstName() {
        return firstName;
    }

    // Returns the middle name
    public String getMiddleName() {
        return middleName;
    }

    // Returns the last name
    public String getLastName() {
        return lastName;
    }

    // Sets the first name to the argument value
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Sets the middle name to the argument value
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Sets the last name to the argument value
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Changes the first, middle, and last names to the argument values
    public void changeNameTo(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Concatenates the last name of the argument Name object onto the end of the calling object's last name
    public void mergeNames(Name other) {
        String mergedLastName = this.lastName + "-" + other.lastName;
        this.lastName = mergedLastName;
        other.lastName = mergedLastName;
    }

    // Returns a String in the format lastName, firstName, middleName
    public String getFullName() {
        return lastName + ", " + firstName + ", " + middleName;
    }

    // Returns a String in the format firstName middleName lastName
    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Returns true when the first, middle, and last names of the argument object match the calling object
    public boolean equals(Name other) {
        return this.firstName.equals(other.firstName) &&
               this.middleName.equals(other.middleName) &&
               this.lastName.equals(other.lastName);
    }

    // Helper method to generate random names
    private static String getRandomName() {
        String[] names = {"John", "Jane", "Alex", "Emily", "Chris", "Katie", "Michael", "Sarah", "David", "Laura"};
        return names[new Random().nextInt(names.length)];
    }
}
