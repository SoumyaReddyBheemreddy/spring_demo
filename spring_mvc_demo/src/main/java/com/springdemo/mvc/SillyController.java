package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// to over come ambiguity over /showForm  we create a parent mapping
@RequestMapping("/hello")
public class SillyController {
    @RequestMapping("/showForm")
    public String displayTheForm(){
        return "silly";
    }
}
