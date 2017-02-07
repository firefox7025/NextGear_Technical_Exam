package com.common;

import com.domain.Student;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Generate Student Class</h1>
 * <p>
 *     This class is a class that can be used as a Factory of students.
 *
 *     Colleges only can dream of such functionality.
 * </p>
 */
public class GenerateStudent {




    public GenerateStudent(){
        generateStudent();
    }


    public List<Student> students = new LinkedList<>();

    private Student generateStudent(){
        long studentcap = 700000000;
        long current = 0;


        System.out.println("Final");

        return new Student();
    }
}
