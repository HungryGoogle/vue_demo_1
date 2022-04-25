package com.example.test.controller;


import com.example.test.util.IpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/helloIp", method = RequestMethod.GET)
    public String test(HttpServletRequest request){

        //获取IP地址
        String ipAddress = IpUtil.getIpAddr(request);
        System.out.println("hello ip = " + ipAddress);
        return ipAddress;
    }

}
