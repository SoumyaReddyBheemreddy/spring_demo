package com.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args){
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        try{
            System.out.println("Connecting to database"+jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("Connection successful!!!");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
