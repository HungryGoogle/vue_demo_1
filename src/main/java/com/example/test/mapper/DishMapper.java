package com.example.test.mapper;

import com.example.test.bean.DishBean;
import com.example.test.bean.UserBean;

import java.util.List;

public interface DishMapper {

    //查询所有用户
    List<DishBean> getWeekDishes();

}
