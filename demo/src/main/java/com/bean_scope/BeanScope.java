package com.bean_scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScope {
    public static void main(String[] args){
        // load spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
        //retrieve bean from spring container
        Coach headBaseBallCoach = context.getBean("baseBallCoach",Coach.class);
        Coach juniorBaseBallCoach = context.getBean("baseBallCoach",Coach.class);
        // check if they are the same
        // bean default scope singleton
        boolean result = (headBaseBallCoach==juniorBaseBallCoach);
        System.out.println("\nPointing to the same object "+result);
        System.out.println("\nMemory location for head coach "+headBaseBallCoach);
        System.out.println("\nMemory location for junior coach "+juniorBaseBallCoach);
        Coach headTrackCoach = context.getBean("trackCoach",Coach.class);
        Coach juniorTrackCoach = context.getBean("trackCoach",Coach.class);
        boolean prototypeResult = (headTrackCoach==juniorTrackCoach);
        System.out.println("\nPointing to the same object "+prototypeResult);
        System.out.println("\nMemory location for head coach "+headTrackCoach);
        System.out.println("\nMemory location for junior coach "+juniorTrackCoach);
        // close the context
        context.close();
    }
}
