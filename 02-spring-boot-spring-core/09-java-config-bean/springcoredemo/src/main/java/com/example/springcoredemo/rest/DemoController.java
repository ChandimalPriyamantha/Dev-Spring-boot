package com.example.springcoredemo.rest;



import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
public class DemoController {
    // define a private filed for the dependency
    private Coach myCoach;


    @Autowired
    public void DemoController(@Qualifier("aquatic") Coach theCoach
                              ){
        System.out.println("In constructor: " + getClass().getName());
        myCoach = theCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){

        return myCoach.getDailyWorkout();
    }

    @GetMapping("/index")
    public String countdown(Model model) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime newYear = LocalDateTime.of(now.getYear() + 1, 1, 1, 0, 0);
        long seconds = ChronoUnit.SECONDS.between(now, newYear);
        model.addAttribute("seconds", seconds);
        return "index";
    }






}
