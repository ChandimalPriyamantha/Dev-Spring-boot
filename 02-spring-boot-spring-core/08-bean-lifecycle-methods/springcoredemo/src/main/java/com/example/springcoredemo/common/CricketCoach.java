package com.example.springcoredemo.common;



import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getName());
    }

    // define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff():"+getClass().getSimpleName());
    }
    // define our destroy method

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff():"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Hi Today, you have to practice cricket: )-";
    }
}
