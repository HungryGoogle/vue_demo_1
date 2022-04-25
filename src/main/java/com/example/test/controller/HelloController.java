package com.example.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("TestApplication main");
        return "index";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("hello sayHello");
        return "index";
    }

}
