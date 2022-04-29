package com.example.test.mapper;

import com.example.test.bean.DishBean;
import com.example.test.bean.UserBean;

import java.util.List;

public interface DishMapper {

    //插入新的用户
    int insertDish(DishBean dishBean);

    //删除用户
    int deleteAllDishes();

    //查询所有用户
    List<DishBean> getWeekDishes();
}
