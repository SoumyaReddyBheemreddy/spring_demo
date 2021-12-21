package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account,boolean vipFlag){
        System.out.println(getClass()+": Doing my DB work : Adding account\n");
    }
    public void updateAccount(){
        System.out.println(getClass()+": Doing my DB work : updating account\n");
    }
}
