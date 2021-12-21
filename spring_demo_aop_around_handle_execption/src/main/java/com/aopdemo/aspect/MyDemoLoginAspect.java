package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {
    private Logger logger =
            Logger.getLogger(MyDemoLoginAspect.class.getName());


    //here ProceedingJoinPoint target method
    @Around("execution(* com.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        //print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @After (finally) on method: "+method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        //now,let's execute the method
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception exception){
            //log the exception
            logger.info(exception.getMessage());
            //give result by solving exception
            result = "Major accident! But no worries,"
                     +"your private AOP helicopter is on the way!";            // rethrow exception
            //throw exception;
        }
        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end-begin;
        logger.info("\n===> Duration: "+duration/1000.0+" seconds");

        return result;
    }
    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public  void afterFinallyAccountsAdvice(JoinPoint joinPoint){
             // print out which method we are advising on
            String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @After (finally) on method: "+method);
    }
    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public  void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,
                                                 Throwable exception){
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterThrowing on method "+method);
        //log the exception
        logger.info("\n====>>> The exception is: "+exception);

    }
    // add a new advice for @AfterReturning
    @AfterReturning(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint
                                                    , List<Account> result){
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterReturning on method "+method);
        // print out the results of the method call
        logger.info("\n====>>> result is: "+result);
        //let's post-process the data .... let's modify it:-

        //convert the account names to uppewrcase
        covertAccoubtNamesToUpperCase(result);

        logger.info("\n====>>> result is: "+result);

    }

    private void covertAccoubtNamesToUpperCase(List<Account> result) {
            //loop through account
        for(Account account:result){
            //get upper case version on name
            String upperName = account.getName().toUpperCase(Locale.ROOT);
            // update the name on the account
            account.setName(upperName);
        }
    }

    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        logger.info("\n=====>>> Executing @Before advice on method");
        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // display method arguments
        logger.info("Method: "+methodSignature);

        //get arguments
        Object[] args = joinPoint.getArgs();
        //loop thru argument
        for(Object argument:args) {
            logger.info(argument.toString());
            if(argument instanceof Account){
                Account account = (Account) argument;
                logger.info("account name "+account.getName());
                logger.info("account level "+account.getLevel());
            }
        }
    }



}
