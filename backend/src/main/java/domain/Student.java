package domain;

import java.util.Date;
import java.util.UUID;

/**
 * <h1>Student Class</h1>
 * <p>
 * <p>
 * The Student class is a class that stores the basic information about a student.
 * This object should contain get and set actions in order to be serializable.
 * </p>
 */
public class Student {

    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String homePhone;
    private String cellPhone;
    private String email;
    private UUID id;

    /**
     * @return The first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName Set the first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Set the last name of the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The middle name of the student
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName Set the middle name of the student
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return The birth date of the student (java.util.date format)
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate Set the birthdate of the student
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return The home phone of the student
     */
    public String getHomePhone() {
        return homePhone;
    }


    /**
     * @param homePhone Sets the home phone number of the student
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * @return The students cell phone
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellPhone Sets the students cellphone number
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return The Students email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Sets the students email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The Students ID number
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id A unique ID number for the student. This field MUST be set in order to be a proper student.
     */
    public void setId(UUID id) {
        this.id = id;
    }
}
