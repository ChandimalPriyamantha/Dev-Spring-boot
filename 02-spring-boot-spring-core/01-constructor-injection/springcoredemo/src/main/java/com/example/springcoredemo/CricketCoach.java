package com.example.springcoredemo;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I love you, Tharuka, I'll make 100 babies with you.";
    }
}
