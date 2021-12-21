package com.bean_scope;

import com.annotation_dependency_injection.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
/* the default bean id will be lower camel case of class name */
@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;
    //Constructor Injection
    @Autowired
    public TennisCoach(@Qualifier("rest") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
