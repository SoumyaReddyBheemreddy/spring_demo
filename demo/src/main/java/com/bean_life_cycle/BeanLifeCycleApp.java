package com.bean_life_cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycleApplicationContext.xml");
        Coach headTrackCoach = context.getBean("trackCoach",Coach.class);
        System.out.println(headTrackCoach.getDailyWorkOut());
        context.close();
    }
}
