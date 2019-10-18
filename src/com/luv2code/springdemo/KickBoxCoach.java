package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class KickBoxCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Jab Cross Left Hook Right Hook - 30 reps";
    }
}
