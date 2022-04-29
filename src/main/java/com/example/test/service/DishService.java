package com.example.test.service;

import com.example.test.bean.DishBean;

import java.util.List;

public interface DishService {
    //查询周菜单
    List<DishBean> queryWeekDishes();

    //查询周菜单
    int insertDish(DishBean dishBean);

    //查询周菜单
    int deleteAllDishes();
}
