package com.overview;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args){
        // load the spring configuration file
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean from spring container
            CricketCoach cricketCoach = context.getBean("cricketCoach",CricketCoach.class);

        //call methods on the bean
        System.out.println(cricketCoach.getDailyWorkOut());
        System.out.println(cricketCoach.getDailyFortune());
        // call new methods to get literal values
        System.out.println(cricketCoach.getEmailAddress());
        System.out.println(cricketCoach.getTeam());
        //close the context
        context.close();
    }
}
