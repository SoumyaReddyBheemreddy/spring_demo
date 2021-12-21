package com.bean_life_cycle;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It :"+fortuneService.getFortune();
    }
    // add an init method
    public void doMyStartUpStuff(){
        System.out.println("Track Coach : inside method doMyStartUpStuff");
    }
    // add a destroy method
    public void doMyCleanUpStuff(){
        System.out.println("Track Coach : inside method doMyCleanUpStuff");
    }
}
