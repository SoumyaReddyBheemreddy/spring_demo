package com.bean_scope;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;



    //create no arg constructor
    public CricketCoach() {
        System.out.println("Cricket coach : inside no arg constructor");
    }
    // setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Cricket coach : inside fortune service  setter method");
        this.fortuneService = fortuneService;
    }
    public void setEmailAddress(String emailAddress) {
        System.out.println("Cricket coach : inside email setter method");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("Cricket coach : inside team setter method");
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
