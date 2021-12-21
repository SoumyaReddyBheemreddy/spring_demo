package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
    public void addAccount(){
        System.out.println(getClass()+": Doing my DB work : Adding Membership Account\n");
    }
    public boolean addMember(){
        System.out.println(getClass()+": Doing my DB work : Adding  member\n");
        return true;
    }
}
