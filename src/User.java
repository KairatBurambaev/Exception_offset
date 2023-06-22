import java.io.File;
public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private String phoneNumber;
    private char gender;

    public User(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return firstName + " " + lastName + " " + middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String toFileString() {
        return lastName + " " + firstName + " " + middleName + " " +
                birthDate + " " +
                phoneNumber + " " + gender + "\n";
    }

    public File getLastName() {
        return new File(lastName);
    }
}
