package com.example.springdemo.service;

import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    //need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    public CustomerServiceImpl() {
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
    @Override
    @Transactional
    public Customer getCustomers(int id) {
        return customerDAO.getCustomers(id);
    }
    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
            customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}
