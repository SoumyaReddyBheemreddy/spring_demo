package com.bean_life_cycle;

public class BaseBallCoach implements Coach {
    private FortuneService fortuneService;
    //define a construction for dependency injection
    BaseBallCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
    @Override
    public String getDailyWorkOut(){
        return  "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        //use fortune service to get a fortune
        return fortuneService.getFortune();
    }
}
