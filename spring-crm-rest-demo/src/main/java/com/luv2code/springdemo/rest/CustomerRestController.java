package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    //auto wire the customer service
    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        return customerService.getCustomers();
    }
    //add mapping for GET /customer/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer==null)
            throw new RuntimeException("Customer id not found - "+customerId);
        return customer;
    }
    // add mapping for POST /customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        // also just in case the pass is in JSON ...set id to 0
        //this is force a save of new item ... instead of update
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }
    // add mapping for PUT /customers - update a customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }
    // add mapping for DELETE /customers/{customerId}} - delete a customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = getCustomer(customerId);
        if(customer==null)
            throw  new CustomerNotFoundException("Customer id not found - "+customerId);

        customerService.deleteCustomer(customerId);
        return "Deleted customer id - "+customerId;
    }
}
