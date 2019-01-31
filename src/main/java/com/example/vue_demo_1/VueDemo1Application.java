package com.example.vue_demo_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class VueDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(VueDemo1Application.class, args);
    }

    @RequestMapping("/hello")
    public String freemarker() {
        return "hello";
    }
}

