package com.annotation_dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements  FortuneService{
    @Override
    public String getFortune() {
        return "Database Fortune";
    }
}
