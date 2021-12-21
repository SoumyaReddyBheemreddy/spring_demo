package com.example.springdemo.service;

import com.example.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public Customer getCustomers(int id);
    public void saveCustomer(Customer customer);
    public void deleteCustomer(int id);
}
