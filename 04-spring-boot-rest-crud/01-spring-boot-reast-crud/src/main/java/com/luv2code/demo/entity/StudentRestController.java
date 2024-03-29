package com.luv2code.demo.entity;

import com.luv2code.demo.rest.StudentErrorResponse;
import com.luv2code.demo.rest.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        // check the studentID again list size
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw  new StudentNotFoundException("Student id not found - " + studentId);

        }

        return theStudents.get(studentId);
    }

    // add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // create a studentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // add another exception handler  ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exc){


            // create a studentErrorResponse
            StudentErrorResponse error = new StudentErrorResponse();

            error.setStatus(HttpStatus.BAD_REQUEST.value());
            error.setMessage(exc.getMessage());
            error.setTimeStamp(System.currentTimeMillis());

            // return ResponseEntity

            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);


    }

}
