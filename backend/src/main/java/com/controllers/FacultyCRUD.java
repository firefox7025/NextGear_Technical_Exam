package com.controllers;

import com.domain.Faculty;
import com.domain.Student;
import com.google.gson.Gson;
import com.repository.FacultyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

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
    public Faculty getFaculty(@RequestParam(value = "id") String id) {

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
     * <h1>Update Faculty</h1>
     * <p>This method is the endpoint that allows for </p>
     * @return updated student values
     */
    @RequestMapping(method = RequestMethod.POST)
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        repository.save(faculty);
        return repository.findOne(faculty.getEIN());
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
     */

    @RequestMapping(method = RequestMethod.PUT)
    public Faculty createFaculty(@RequestBody Faculty faculty) {

        if(faculty.getEIN() == null){
            faculty.setEIN(UUID.randomUUID().toString());
        }

        repository.save(faculty);
        return faculty;
    }


    /**
     * <h1>Populate Faculty</h1>
     *
     * @throws Exception <p>
     *                   Systems without students are boring!
     *                   So add 100 students to the system with a single rest call.
     *                   </p>
     */
    @RequestMapping(value = "populate")
    public void generateFaculty(){

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
