package com.example.test.controller;

import com.example.test.bean.DishBean;
import com.example.test.service.DishService;
import com.example.test.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    DishService dishService;

    /**
     * 查询所有用户信息
     * @param modelMap
     * @return
     */
    @RequestMapping("/weekDishes")
    public String showUsers(ModelMap modelMap){
        List<DishBean> dishList = dishService.queryWeekDishes();
        modelMap.addAttribute("weekDishes",dishList);
        LogUtil.info("list size = " + dishList.size());
        // 返回周菜单
//        return "users";
        return "weekDishes";
    }


}
