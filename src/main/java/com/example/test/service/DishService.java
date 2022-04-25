package com.example.test.service;

import com.example.test.bean.DishBean;
import com.example.test.bean.UserBean;

import java.util.List;

public interface DishService {
    //查询周菜单
    List<DishBean> queryWeekDishes();
}
