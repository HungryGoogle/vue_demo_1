package com.example.test.serviceImpl;

import com.example.test.bean.DishBean;
import com.example.test.mapper.DishMapper;
import com.example.test.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    //将DAO注入Service层
    @Autowired
    DishMapper dishMapper;


    @Override
    public List<DishBean> queryWeekDishes() {
        return dishMapper.getWeekDishes();
    }
}
