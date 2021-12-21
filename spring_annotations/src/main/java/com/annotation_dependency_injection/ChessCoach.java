package com.annotation_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach{
    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Playing chess";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
