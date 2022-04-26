package com.example.test.controller;


import com.alibaba.excel.EasyExcel;
import com.example.test.bean.PhoneAttachExcel;
import com.example.test.serviceImpl.ReadExcelUtil;
import com.example.test.util.IpUtil;
import com.example.test.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        LogUtil.info("[lee-->]LoggerFactory sayHello");
        ReadExcelUtil readExcelUtil = new ReadExcelUtil();
        File file = new File("D:/lldizhi1.xls");
        EasyExcel.read(file,ReadExcelUtil.class,readExcelUtil)
                .sheet()
                .headRowNumber(1)
                .doRead();
        List<PhoneAttachExcel> list = readExcelUtil.list;


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
