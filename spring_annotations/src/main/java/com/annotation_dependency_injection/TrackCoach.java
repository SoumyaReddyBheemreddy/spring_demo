package com.annotation_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach
{
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Train hard";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    // Method Injection
    @Autowired
    @Qualifier("databaseFortuneService")
    public void doSomethingCrazyStuff(FortuneService fortuneService){
        System.out.println("Track Coach: inside doSomethingCrazyStuff");
        this.fortuneService = fortuneService;
    }
}
