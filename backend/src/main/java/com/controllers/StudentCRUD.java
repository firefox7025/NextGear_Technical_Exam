package com.controllers;

import com.domain.Student;
import com.google.gson.Gson;
import com.repository.StudentClient;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.util.Arrays;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable(value = "id") String id) {

        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean DeleteStudent(@RequestParam(value = "id") String id) {
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
     * @param student The student object to be updated.
     * @return updated student values
     */
    @RequestMapping(method = RequestMethod.POST)
    public Student updateStudent(@RequestBody Student student) {

        repository.save(student);

        return repository.findOne(student.getSIN());
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
     * @param student  A student entry object.
     */

    @RequestMapping(method = RequestMethod.PUT)
    public Student createStudent(@RequestBody Student student) {
        repository.save(student);
        return student;
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
    public void generateStudents() throws Exception {

        Gson gson = new Gson();
        Resource resource = resourceLoader.getResource("classpath:studentdata.json");

        Student[] students = gson.fromJson(new FileReader(resource.getFile()), Student[].class);
        Iterable<Student> iterable = Arrays.asList(students);
        repository.save(iterable);

    }


}
