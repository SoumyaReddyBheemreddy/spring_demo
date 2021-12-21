package com.bean_scope;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your Lucky day!";
    }
}
