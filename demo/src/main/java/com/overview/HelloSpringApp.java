package com.overview;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args){
        //load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean from spring container
        Coach trackCoach = context.getBean("trackCoach",Coach.class);
        Coach baseBallCoach = context.getBean("baseBallCoach",Coach.class);
        //call methods on the bean
        System.out.println(trackCoach.getDailyWorkOut());
        System.out.println(trackCoach.getDailyFortune());
        System.out.println(baseBallCoach.getDailyWorkOut());
        System.out.println(baseBallCoach.getDailyFortune());
        //close the context
        context.close();
    }
}
