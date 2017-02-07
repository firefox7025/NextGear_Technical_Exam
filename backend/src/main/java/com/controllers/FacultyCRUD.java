package com.controllers;

import com.domain.Faculty;
import com.domain.Student;
import com.google.gson.Gson;
import com.repository.FacultyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Date;

/**
 * <h1>Faculty CRUD operations</h1>
 */
@RestController
@RequestMapping(value = "/faculty", produces = MediaType.APPLICATION_JSON_VALUE)
public class FacultyCRUD {

    @Autowired
    private FacultyClient repository;

    @Autowired
    private ResourceLoader resourceLoader;


    @RequestMapping(method = RequestMethod.GET)
    public Faculty getFaculty(@RequestParam(value = "id") long id) {

        return repository.findOne(id);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public boolean DeleteStudent(@RequestParam(value = "id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }


    /**
     * <h1>Update Student</h1>
     * <p>This method is the endpoint that allows for </p>
     *
     * @param id         required
     * @param firstName  not required
     * @param middleName not required
     * @param lastName   not required
     * @param birthDate  not required
     * @param workEmail  not required
     * @return updated student values
     */
    @RequestMapping(method = RequestMethod.POST)
    public Faculty updateFaculty(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "fName", required = false) String firstName,
            @RequestParam(value = "mName", required = false) String middleName,
            @RequestParam(value = "lName", required = false) String lastName,
            @RequestParam(value = "birthDate", required = false) Date birthDate,
            @RequestParam(value = "workEmail", required = false) String workEmail,
            @RequestParam(value = "socialSecurityNumber", required = false) String socialSecurityNumber,
            @RequestParam(value = "personalEmail", required = false) String personalEmail,
            @RequestParam(value = "companyIM", required = false) String companyIM) {

        Faculty faculty = repository.findOne(id);

        if (firstName != null) {
            faculty.setFirstName(firstName);
        }
        if (middleName != null) {
            faculty.setMiddleName(middleName);
        }
        if (lastName != null) {
            faculty.setLastName(lastName);
        }
        if (birthDate != null) {
            faculty.setBirthdate(birthDate);
        }
        if (workEmail != null) {
            faculty.setWorkEmail(workEmail);
        }

        repository.save(faculty);

        return repository.findOne(id);
    }


    /**
     * <h1>Student Creation</h1>
     * <p>
     * This method allows for the creation of a Faculty object, which will then be stored.
     * </p>
     * <h2>ID generation</h2>
     * <p>
     * In order to spare myself the cost of a unique call, and the odds of an UUID being non-unique is insignificant,
     * a random version four UUID seems like a reasonable choice.
     * </p>
     *
     * @param birthDate  The students birth date
     * @param workEmail      The email of the faculty
     * @param firstName  The first name of the faculty
     * @param middleName The middle name of the faculty
     * @param lastName   The last name of the faculty
     * @param socialSecurityNumber The Social security number of the faculty member
     * @param companyIM Because what company doesn't have an im address.
     *
     */

    @RequestMapping(method = RequestMethod.PUT)
    public Faculty createStudent(
            @RequestParam(value = "fName", required = false) String firstName,
            @RequestParam(value = "mName", required = false) String middleName,
            @RequestParam(value = "lName", required = false) String lastName,
            @RequestParam(value = "birthDate", required = false) Date birthDate,
            @RequestParam(value = "workEmail", required = false) String workEmail,
            @RequestParam(value = "socialSecurityNumber", required = false) String socialSecurityNumber,
            @RequestParam(value = "personalEmail", required = false) String personalEmail,
            @RequestParam(value = "companyIM", required = false) String companyIM) {

        Faculty faculty = new Faculty();
        faculty.setFirstName(firstName);
        faculty.setMiddleName(middleName);
        faculty.setLastName(lastName);
        faculty.setBirthdate(birthDate);
        faculty.setWorkEmail(workEmail);
        faculty.setSocialSecurityNumber(socialSecurityNumber);
        faculty.setPersonalEmail(personalEmail);
        faculty.setCompanyIM(companyIM);

        repository.save(faculty);

        return faculty;
    }


    /**
     * <h1>Populate Students</h1>
     *
     * @throws Exception <p>
     *                   Systems without students are boring!
     *                   So add 100 students to the system with a single rest call.
     *                   </p>
     */
    @RequestMapping(value = "populate")
    public void generateStudents(){

        Gson gson = new Gson();
        Resource resource = resourceLoader.getResource("classpath:facultydata.json");

        try {
            Faculty[] faculty = gson.fromJson(new FileReader(resource.getFile()), Faculty[].class);
            Iterable<Faculty> iterable = Arrays.asList(faculty);
            repository.save(iterable);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
