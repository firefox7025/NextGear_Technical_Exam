package com.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <h1>Faculty Class</h1>
 * <p>
 * The Faculty class, would be a class used to store and process employee information.
 * </p>
 */
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long facultyId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private String workEmail;
    private String socialSecurityNumber;
    private String personalEmail;
    private String companyIM;


    /**
     * @return The FacultyId is the unique identification system number assigned to each employee.
     */
    public long getFacultyId() {
        return facultyId;
    }

    /**
     * @param facultyId The id for this faculty member
     */
    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    /**
     * @return the First name of teh employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName Sets the first name of the employee
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * @return The Last name of the employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Sets the last name of the employee
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The middle name of the employee
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName Sets the middle name of the employee
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return The birthday of the employee
     */
    public String getBirthdate() {
        return birthDate;
    }

    /**
     * @param birthDate Sets the birthday of employee
     */
    public void setBirthdate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return The assigned work email for the employee
     */
    public String getWorkEmail() {
        return workEmail;
    }

    /**
     * @param workEmail The assign the work for the employee
     */
    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    /**
     * @return The Personal contact email for the employee
     */
    public String getPersonalEmail() {
        return personalEmail;
    }

    /**
     * @param personalEmail Set the personal email for the employee
     */
    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    /**
     * @return Set the company im address, if the employee has one
     */
    public String getCompanyIM() {
        return companyIM;
    }

    /**
     * @param companyIM Set the company instant message address
     */

    public void setCompanyIM(String companyIM) {
        this.companyIM = companyIM;
    }

    /**
     * @return Get the social security number of the employee
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * @param socialSecurityNumber Set the social security number for the employee
     */

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

}
