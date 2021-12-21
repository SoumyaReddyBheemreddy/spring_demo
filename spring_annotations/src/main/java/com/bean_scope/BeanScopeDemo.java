package com.bean_scope;

import com.annotation_dependency_injection.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {
    public static void main(String[] args){
        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
        // retrieve bean from container
        Coach seniorTennisCoach = context.getBean("tennisCoach",Coach.class);
        Coach juniorTennisCoach = context.getBean("tennisCoach",Coach.class);
        Coach seniorTrackCoach = context.getBean("trackCoach",Coach.class);
        Coach juniorTrackCoach = context.getBean("trackCoach",Coach.class);
        boolean result =(seniorTennisCoach==juniorTennisCoach);
        System.out.println("Tennis coach pointing to same object : "+result);
        System.out.println("Memory location for senior Tennis coach"+seniorTennisCoach);
        System.out.println("Memory location for junior Tennis coach"+juniorTennisCoach);
        boolean trackResult =(seniorTrackCoach==juniorTrackCoach);
        System.out.println("Tennis coach pointing to same object : "+trackResult);
        System.out.println("Memory location for senior Tennis coach"+seniorTrackCoach);
        System.out.println("Memory location for junior Tennis coach"+juniorTrackCoach);
        //close context
        context.close();
    }
}
