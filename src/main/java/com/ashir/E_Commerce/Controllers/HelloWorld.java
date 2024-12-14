package com.ashir.E_Commerce.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorld
{

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/home")
    public String getIndex(){
        return "index";
    }


}
