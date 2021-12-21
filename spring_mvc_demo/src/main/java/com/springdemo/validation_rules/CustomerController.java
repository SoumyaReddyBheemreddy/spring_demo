package com.springdemo.validation_rules;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // add an intiBinder to convert trim input string
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public  void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor =
                 new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customer-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        else {
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
            return "customer-confirmation";
        }
    }
}