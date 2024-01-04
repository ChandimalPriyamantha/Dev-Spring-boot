package com.luv2code.demo.entity;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct  to lead the student data.... only once!
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Chandimal","Priyamantha"));
        theStudents.add(new Student("Yamini","Maltharuka"));
        theStudents.add(new Student("Pathum","Akila"));

    }

    // define endpoint for "/student" - return a list of student.


    @GetMapping("/students")
    public List<Student> getTheStudents() {
        return theStudents;
    }
    //define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list  ... keep it simple for now

        return theStudents.get(studentId);
    }

}
