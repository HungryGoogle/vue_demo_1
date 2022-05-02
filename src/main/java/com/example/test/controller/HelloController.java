package com.example.test.controller;


import com.example.test.bean.DemoData;
import com.example.test.bean.DishBean;
import com.example.test.util.DocUtils;
import com.example.test.util.IpUtil;
import com.example.test.util.LogUtil;
import com.example.test.util.config.DishConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    DishConfig dishConfig;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        LogUtil.info("[lee-->]LoggerFactory sayHello");
        testDoc();

        return "indexVue";
    }

    public void testDoc() {
        try {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("expert_1", "宋广华");
            dataMap.put("expert_2", "王信");
            dataMap.put("expert_3", "秦老师");
            dataMap.put("meeting_date", "2022年9月20日");
            dataMap.put("meeting_time", "上午9:00");
            dataMap.put("meeting_place", "国科大杭州高等研究院7号楼2楼215会议室");
            dataMap.put("sender_name", "李文庆");
            dataMap.put("sender_phone", "0571-12345678");
            dataMap.put("send_date", "2022年9月9日");
            DocUtils.saveWord("d:\\temp\\test.docx", dataMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
