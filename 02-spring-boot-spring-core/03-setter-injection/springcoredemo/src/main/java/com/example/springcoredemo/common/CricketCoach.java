package com.example.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Hi Today, you have to practice cricket: )-";
    }
}
