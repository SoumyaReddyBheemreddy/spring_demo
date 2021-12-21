package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {
    //this is where we ad of our related advices for logging

    //let's start with an @Before advice
    // here public void addAccount() matches on any class
    // @Before("execution(public void addAccount())")
    // to match addAccount only in AccountDAo then we need specify class name
    //@Before("execution(public void com.aopdemo.dao.AccountDAO.addAccount())")
    //method starts with add
    //@Before("execution(public void add*())")
    //for any return type
    //@Before("execution(*  add*())")
    //matching method parameters type
    //@Before("execution(*  add*(com.aopdemo.Account))")
    //matching multiple parameter type
    //@Before("execution(*  add*(com.aopdemo.Account,.. ))")
    //matching multiple parameter type
    //@Before("execution(*  add*(.. ))")
    //any class in package
    @Before("execution(*  com.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method");

    }
    /*@Before("execution(public void updateAccount())")
    public void beforeUpdateAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on updateAccount()");

    }*/
}
