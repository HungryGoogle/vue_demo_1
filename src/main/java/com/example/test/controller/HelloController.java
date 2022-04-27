package com.example.test.controller;


import com.alibaba.excel.EasyExcel;
import com.example.test.bean.DemoData;
import com.example.test.bean.DishBean;
import com.example.test.bean.PhoneAttachExcel;
import com.example.test.serviceImpl.DishMenuExcelListener;
import com.example.test.serviceImpl.ExcelListener;
import com.example.test.serviceImpl.ReadExcelUtil;
import com.example.test.util.IpUtil;
import com.example.test.util.LogUtil;
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
//        ReadExcelUtil readExcelUtil = new ReadExcelUtil();
//        File file = new File("D:/lldizhi1.xls");
//        EasyExcel.read(file,ReadExcelUtil.class,readExcelUtil)
//                .sheet()
//                .headRowNumber(1)
//                .doRead();
//        List<PhoneAttachExcel> list = readExcelUtil.list;
//

//        //1.设置写入文件夹地址和Excel文件名称
        String filename = "d:\\write2.xlsx";
//
        //2.调用easyExcel里面的方法实现写操作
        //write两个参数 参数1：文件路径名称  参数2：实体类class    doWrite方法需要一个list集合
        try {
            EasyExcel.write(filename, DishBean.class).sheet("每周菜单").doWrite(getData2());
            EasyExcel.read(filename, DishBean.class, new DishMenuExcelListener()).sheet().doRead();
        }catch (Exception e){
            LogUtil.info(e.getLocalizedMessage());
        }
        return "index";
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

    @RequestMapping(value = "/helloIp", method = RequestMethod.GET)
    public String test(HttpServletRequest request) {

        //获取IP地址
        String ipAddress = IpUtil.getIpAddr(request);
        System.out.println("hello ip = " + ipAddress);
        return ipAddress;
    }

}
