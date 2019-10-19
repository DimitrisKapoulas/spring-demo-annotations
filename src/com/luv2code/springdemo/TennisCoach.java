package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }


    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

//    // define a setter method
//    @Autowired
//    public void setFortuneService(FortuneService theFortuneService) {
//        System.out.println(">> TennisCoach: inside setter method");
//        fortuneService = theFortuneService;
//    }

    //define my init method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of my doMyCleanupStuff()");
    }

    //define my destroy method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside of my doMyStartupStuff()");
    }

    @Override
    public String getDailyWorkout() {
        return "Practise 20 backhands";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
