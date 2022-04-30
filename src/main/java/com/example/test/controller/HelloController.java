package com.example.test.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.test.bean.DemoData;
import com.example.test.bean.DishBean;
import com.example.test.bean.PhoneAttachExcel;
import com.example.test.serviceImpl.DishMenuExcelListener;
import com.example.test.serviceImpl.ExcelListener;
import com.example.test.serviceImpl.ReadExcelUtil;
import com.example.test.util.IpUtil;
import com.example.test.util.LogUtil;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        LogUtil.info("[lee-->]LoggerFactory sayHello");
        return "indexVue";
    }

    //创建一个方法，让其返回list集合
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("lucky" + i);
            list.add(data);
        }
        return list;
    }

    //创建一个方法，让其返回list集合
    private static List<DishBean> getData2() {
        List<DishBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DishBean data = new DishBean();
            data.setDishName("菜名" + i);
            data.setDishPrice((float) (i * 7 % 11 * 1.0 /2));
            data.setDishType("热菜");
            data.setMealtime("早餐");
            data.setWhichWeekDay("周一");
            list.add(data);
        }
        return list;
    }


    //创建一个方法，让其返回list集合
    private static List<DishBean> getData3() {
        List<DishBean> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            DishBean data = new DishBean();
            data.setDishName("菜名3" + i);
            data.setDishPrice((float) (i * 7 % 11 * 1.0 /2));
            data.setDishType("热菜3");
            data.setMealtime("早餐3");
            data.setWhichWeekDay("周3");
            list.add(data);
        }
        return list;
    }

    @RequestMapping(value = "/helloIp", method = RequestMethod.GET)
    public String test(HttpServletRequest request) {

        //获取IP地址
        String ipAddress = IpUtil.getIpAddr(request);
        System.out.println("hello ip = " + ipAddress);
        return ipAddress;
    }

}
