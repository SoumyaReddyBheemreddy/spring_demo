package com.annotation_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    private  FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice base ball";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    //Setter Injection
    @Autowired
    @Qualifier("randomFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Base Ball : inside setter method");
        this.fortuneService = fortuneService;
    }

}
