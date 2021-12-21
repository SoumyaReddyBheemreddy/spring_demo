package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args){
        // read spring Config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
        MemberShipDAO memberShipDAO = context.getBean("memberShipDAO",MemberShipDAO.class);
        //call the business method
        Account account = new Account();
        accountDAO.addAccount(account,true);
        accountDAO.updateAccount();
        memberShipDAO.addAccount();
        memberShipDAO.addMember();
        /*do it again
        System.out.println("\n let's call it again!\n");
        //call the business method
        accountDAO.addAccount();
        accountDAO.updateAccount();
        */
        //close the context
        context.close();
    }
}
