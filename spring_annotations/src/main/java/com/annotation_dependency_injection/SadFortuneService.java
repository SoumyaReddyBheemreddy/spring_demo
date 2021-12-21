package com.annotation_dependency_injection;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Today is  a sad day";
    }
}
