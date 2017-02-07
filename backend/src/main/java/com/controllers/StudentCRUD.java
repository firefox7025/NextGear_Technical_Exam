package com.controllers;

import com.domain.Student;
import com.google.gson.Gson;
import com.repository.StudentClient;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Date;

/**
 * <h1>Student CRUD Operations</h1>
 * <p>
 * This is the controller for preforming creation, reading, updating, and Deleting
 * </p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentCRUD {

    @Autowired
    private StudentClient repository;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(method = RequestMethod.GET)
    public Student getStudent(@RequestParam(value = "id") long id) {

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
     * @param homePhone  not required
     * @param cellphone  not required
     * @param email      not required
     * @return updated student values
     */
    @RequestMapping(method = RequestMethod.POST)
    public Student updateStudent(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "fName", required = false) String firstName,
            @RequestParam(value = "mName", required = false) String middleName,
            @RequestParam(value = "lName", required = false) String lastName,
            @RequestParam(value = "birthDate", required = false) Date birthDate,
            @RequestParam(value = "homePhone", required = false) String homePhone,
            @RequestParam(value = "cellphone", required = false) String cellphone,
            @RequestParam(value = "email", required = false) String email) {

        Student student = repository.findOne(id);

        if (firstName != null) {
            student.setFirstName(firstName);
        }
        if (middleName != null) {
            student.setMiddleName(middleName);
        }
        if (lastName != null) {
            student.setLastName(lastName);
        }
        if (birthDate != null) {
            student.setBirthDate(birthDate);
        }
        if (homePhone != null) {
            student.setHomePhone(homePhone);
        }
        if (cellphone != null) {
            student.setCellPhone(cellphone);
        }
        if (email != null) {
            student.setEmail(email);
        }

        repository.save(student);

        return repository.findOne(id);
    }


    /**
     * <h1>Student Creation</h1>
     * <p>
     * This method allows for the creation of a student object, which will then be stored.
     * </p>
     * <h2>ID generation</h2>
     * <p>
     * In order to spare myself the cost of a unique call, and the odds of an IU being guessable,
     * a random version four UUID seems like a reasonable choice.
     * </p>
     *
     * @param birthDate  The students birth date
     * @param cellphone  The cellphone number of the student
     * @param email      The email of the student
     * @param firstName  The first name of the student
     * @param middleName The middle name of the student
     * @param homePhone  The home phone of the student
     * @param lastName   The last name of the student
     */

    @RequestMapping(method = RequestMethod.PUT)
    public Student createStudent(
            @RequestParam(value = "fName") String firstName,
            @RequestParam(value = "mName", required = false) String middleName,
            @RequestParam(value = "lName") String lastName,
            @RequestParam(value = "birthDate") Date birthDate,
            @RequestParam(value = "homePhone", required = false) String homePhone,
            @RequestParam(value = "cellphone") String cellphone,
            @RequestParam(value = "email") String email
    ) {

        Student student = new Student();
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setLastName(lastName);
        student.setBirthDate(birthDate);
        student.setHomePhone(homePhone);
        student.setCellPhone(cellphone);
        student.setEmail(email);

        repository.save(student);

        return student;
    }


    /**
     * <h1>Populate Students</h1>
     * @throws Exception
     *
     * <p>
     *     Systems without students are boring!
     *     So add 100 students to the system with a single rest call.
     * </p>
     *
     */
    @RequestMapping(value = "populate")
    public void generateStudents() throws Exception {

        Gson gson = new Gson();
        Resource resource = resourceLoader.getResource("classpath:studentdata.json");

        Student[] students = gson.fromJson(new FileReader(resource.getFile()), Student[].class);
        Iterable<Student> iterable = Arrays.asList(students);
        repository.save(iterable);

    }



}
