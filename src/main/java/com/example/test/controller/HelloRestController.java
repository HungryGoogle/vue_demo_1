package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/restString")
    public String book() {
        return "This is a restString";
    }
}