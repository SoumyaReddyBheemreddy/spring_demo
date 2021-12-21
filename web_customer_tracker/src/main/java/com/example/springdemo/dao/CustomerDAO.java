package com.example.springdemo.dao;

import com.example.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer>  getCustomers();
    public Customer getCustomers(int id);
    public void saveCustomer(Customer customer);
    public void deleteCustomer(int id);
}
