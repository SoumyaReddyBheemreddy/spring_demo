package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args){
        // read spring Config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService",TrafficFortuneService.class);
        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        String data = trafficFortuneService.getFortune();
        System.out.println("\nMy fortune is : "+data);
        System.out.println("Finished");

        //close the context
        context.close();
    }
}
