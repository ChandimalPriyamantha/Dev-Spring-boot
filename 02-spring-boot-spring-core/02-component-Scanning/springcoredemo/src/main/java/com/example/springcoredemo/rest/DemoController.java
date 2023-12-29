package com.example.springcoredemo.rest;


import com.luv2code.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private filed for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    //@Autowired annotation tells Spring to inject a dependency
    @Autowired
    public DemoController(Coach theCoach){

        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}
