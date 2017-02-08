package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

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

    @Id
    private String SIN;
    private String firstName;
    private String lastName;
    private String middleName;
    private String personalEmail;
    private double amountOwed;
    private String schoolEmail;
    private String homeAddress;
    private String socialSecurityNumber;
    private Date birthDate;
    private String gender;
    private String university;


    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
