package com.domain;

import javax.persistence.*;
import java.io.Serializable;
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
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String homePhone;
    private String cellPhone;
    private String email;
    @Id
    private UUID Id;


    public Student(String firstName, String lastName, String middleName, Date birthDate, String homePhone, String cellPhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.email = email;
    }

    public Student() {
        setId(UUID.randomUUID());
    }

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
     * @return The internal ID for the user.
     */
    public UUID getId() {

        return Id;
    }

    /**
     * @param uuid Sets the internal UUID
     */
    public void setId(UUID uuid) {
        this.Id = uuid;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", homePhone='" + homePhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", email='" + email + '\'' +
                ", Id=" + Id +
                '}';
    }

}
