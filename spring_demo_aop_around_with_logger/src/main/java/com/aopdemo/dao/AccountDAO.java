package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;
    //add a new method : findAccounts()
    public List<Account> findAccounts(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("No accounts available");
        }
        List<Account> accounts = new ArrayList<>();
        //create sample accounts
        Account account1 = new Account("John","Sliver");
        Account account2 = new Account("Sam","Platinum");
        Account account3 = new Account("Luca","Gold");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }
    public void addAccount(Account account,boolean vipFlag){
        System.out.println(getClass()+": Doing my DB work : Adding account\n");
    }
    public void doWork(){
        System.out.println(getClass()+": Doing my DB work : doWork\n");
    }

    public String getName() {
        System.out.println(getClass()+": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
