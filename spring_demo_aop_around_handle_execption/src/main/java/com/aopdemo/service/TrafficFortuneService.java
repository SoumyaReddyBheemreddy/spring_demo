package com.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class TrafficFortuneService {
    // simulate a delay
    public  String getFortune(){
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }
        //return a fortune
        return "Expect heavy traffic this morning";
    }
    public  String getFortune(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("Major accident! Highway is closed");
        }
        return "Expect heavy traffic this morning";
    }
}
