package com.bean_scope;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "The journey is the reward",
            "Diligence is the mother of good kuck"
    };
    private Random myRandom = new Random();
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        return data[index];
    }
}
