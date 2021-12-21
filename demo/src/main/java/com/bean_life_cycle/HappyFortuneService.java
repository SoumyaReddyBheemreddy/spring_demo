package com.bean_life_cycle;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your Lucky day!";
    }
}
