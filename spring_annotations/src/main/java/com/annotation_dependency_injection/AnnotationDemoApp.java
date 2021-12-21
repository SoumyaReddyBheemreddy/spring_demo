package com.annotation_dependency_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args){
        //read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dependencyApplicationContext.xml");
        // get bean from container
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        Coach baseBallCoach = context.getBean("baseBallCoach",Coach.class);
        Coach trackCoach = context.getBean("trackCoach",Coach.class);
        Coach cricketCoach = context.getBean("cricketCoach",Coach.class);
        // call a method on the bean
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());
        System.out.println(baseBallCoach.getDailyWorkout());
        System.out.println(baseBallCoach.getDailyFortune());
        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());
        // close the context
        context.close();
    }
}
