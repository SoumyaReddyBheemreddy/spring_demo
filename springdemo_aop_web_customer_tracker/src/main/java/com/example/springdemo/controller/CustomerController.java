package com.example.springdemo.controller;

import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
 // need to inject customer service
    @Autowired
    private CustomerService customerService;
    @GetMapping("/list")
    public String list(Model model){
        //get customer from dao
        List<Customer> customers = customerService.getCustomers();
        //add the customers to the model
        model.addAttribute("customers",customers);
        return  "list-customers";
    }
    @GetMapping("/showFormForAdd")
    public  String showFormForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        //save the customer using our service;
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public  String showFormForUpdate(@RequestParam("customerId") int id,
                                     Model model){
        Customer customer = customerService.getCustomers(id);
        model.addAttribute("customer",customer);
        return  "customer-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

}