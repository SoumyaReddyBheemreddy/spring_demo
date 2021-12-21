package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {
    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public  void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,
                                                 Throwable exception){
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method "+method);
        //log the exception
        System.out.println("\n====>>> The exception is: "+exception);

    }
    // add a new advice for @AfterReturning
    @AfterReturning(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint
                                                    , List<Account> result){
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method "+method);
        // print out the results of the method call
        System.out.println("\n====>>> result is: "+result);
        //let's post-process the data .... let's modify it:-

        //convert the account names to uppewrcase
        covertAccoubtNamesToUpperCase(result);

        System.out.println("\n====>>> result is: "+result);

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
