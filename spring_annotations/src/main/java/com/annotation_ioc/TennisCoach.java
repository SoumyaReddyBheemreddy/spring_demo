package com.annotation_ioc;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
/* the default bean id will be lower camel case of class name */
//@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
