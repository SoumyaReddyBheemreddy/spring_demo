package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n=====>>> Executing @Before advice on method");
        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // display method arguments
        System.out.println("Method: "+methodSignature);

        //get arguments
        Object[] args = joinPoint.getArgs();
        //loop thru argument
        for(Object argument:args) {
            System.out.println(argument);
            if(argument instanceof Account){
                Account account = (Account) argument;
                System.out.println("account name "+account.getName());
                System.out.println("account level "+account.getLevel());
            }
        }
    }



}
