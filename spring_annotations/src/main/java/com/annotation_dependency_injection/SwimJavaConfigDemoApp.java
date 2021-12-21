package com.annotation_dependency_injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args){
        // read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);
        // get bean from container
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        Coach baseBallCoach = context.getBean("baseBallCoach",Coach.class);
        Coach trackCoach = context.getBean("trackCoach",Coach.class);
        Coach cricketCoach = context.getBean("cricketCoach",Coach.class);
        // from non xml
        SwimCoach swimCoach = context.getBean("swimCoach",SwimCoach.class);
        // call a method on the bean
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());
        System.out.println(baseBallCoach.getDailyWorkout());
        System.out.println(baseBallCoach.getDailyFortune());
        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune());
        System.out.println(swimCoach.getEmail());
        System.out.println(swimCoach.getTeam());
        // close the context
        context.close();
    }
}
