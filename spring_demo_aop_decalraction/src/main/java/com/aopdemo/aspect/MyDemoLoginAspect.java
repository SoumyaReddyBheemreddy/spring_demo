package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {
    @Pointcut("execution(*  com.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method");

    }
    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n====>>> Performing API analytics ");
    }
}
