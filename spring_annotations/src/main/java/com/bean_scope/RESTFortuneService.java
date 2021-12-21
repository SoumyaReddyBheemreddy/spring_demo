package com.bean_scope;

import org.springframework.stereotype.Component;

@Component("rest")
public class RESTFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "REST Fortune";
    }
}
