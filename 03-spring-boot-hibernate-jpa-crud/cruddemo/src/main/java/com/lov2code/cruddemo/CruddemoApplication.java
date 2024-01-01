package com.lov2code.cruddemo;

import com.lov2code.cruddemo.dao.StudentDAO;
import com.lov2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudent(studentDAO);
            //readStudent(studentDAO);

            //queryForStudent(studentDAO);

            //queryForStudentByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            //deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {

        System.out.println("Deleting all student..");
        int numRowDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;

        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);


    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Scooby
        System.out.println("Updating student....");
        myStudent.setFirstName("Scooby");


        // update the student
        studentDAO.update(myStudent);


        // display the update student
        System.out.println("Updated student: " + myStudent);

    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {
        //get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Doe");

        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);

        }
    }

    private void queryForStudent(StudentDAO studentDAO) {

        //get a list of student
        List<Student> theStudent = studentDAO.findAll();

        for(Student tempStudent : theStudent){
            System.out.println(tempStudent);
        }

        // display list of students
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object....");
        Student tempStudent = new Student("Daffy","Duck","deffy@love2code.com");

        // save the student
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generates id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        //display student

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        // create multiple students

        System.out.println("Creating new 3 student object...");
        Student tempStudent1 = new Student("Sadeepa","Lakshan","paul@love2code.com");
        Student tempStudent2 = new Student("Yamini","Maltharuka","paul@love2code.com");
        Student tempStudent3 = new Student("Gimhani","Galabodage","paul@love2code.com");



        // save the 3 student objects
        System.out.println("Saving the students....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Paul","Doe","paul@love2code.com");

        // save the student object
        System.out.println("Saving the student....");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saves student. Generated id: " + tempStudent.getId());
    }


}
