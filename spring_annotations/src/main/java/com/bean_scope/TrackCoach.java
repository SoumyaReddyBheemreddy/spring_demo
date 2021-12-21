package com.bean_scope;

import com.annotation_dependency_injection.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
    @Qualifier("happyFortuneService")
    public void doSomethingCrazyStuff(FortuneService fortuneService){
        System.out.println("Track Coach: inside doSomethingCrazyStuff");
        this.fortuneService = fortuneService;
    }
}
