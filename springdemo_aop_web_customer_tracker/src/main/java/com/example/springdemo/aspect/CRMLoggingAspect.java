package com.example.springdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger
    private Logger logger =
            Logger.getLogger(getClass().getName());
    //setup pointcut declaration
    @Pointcut("execution(* com.example.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}
    //do same for service and dao
    @Pointcut("execution(* com.example.springdemo.service.*.*(..))")
    private void forServicePackage(){}
    @Pointcut("execution(* com.example.springdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage()||forDAOPackage()")
    private  void forAppFlow(){}
    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====> in @Before : calling method :"+method);
        //display the argument to the method
        //get the argument
        Object[] arguments = joinPoint.getArgs();
        //loop thru and display argument
        for(Object argument:arguments)
            logger.info("\n"+argument.toString());

    }


    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint,Object result){
        //display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====> in @AfterReturning : calling method :"+method);
        //display data returned
        logger.info("\n====> result: "+result);
    }
}
