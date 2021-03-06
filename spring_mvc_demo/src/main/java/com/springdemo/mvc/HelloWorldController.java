package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
@Controller
public class HelloWorldController {
    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-home";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    //new  controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        //read the request parameter from
        String name =  request.getParameter("studentName");
        //convert the data to all caps
        name = name.toUpperCase();
        // create the message
        String result = "Yo! "+name;
        // add message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model){

        //convert the data to all caps
        name = name.toUpperCase();
        // create the message
        String result = "Welcome , "+name;
        // add message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }
}
