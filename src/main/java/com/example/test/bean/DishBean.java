package com.example.test.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DishBean {
    @ExcelIgnore
    private int id;
    @ExcelProperty(value = "周几",index = 0)
    private String whichWeekDay;    //周几
    @ExcelProperty(value = "餐名",index = 1)
    private String mealtime;        //菜名
    @ExcelProperty(value = "菜类",index = 2)
    private String dishType;        //餐名，早餐、中餐、晚餐、夜宵
    @ExcelProperty(value = "菜名",index = 3)
    private String dishName;        //热菜、凉菜、汤、炖菜
    @ExcelProperty(value = "菜价",index = 4)
    private float dishPrice;       // 菜的价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhichWeekDay() {
        return whichWeekDay;
    }

    public void setWhichWeekDay(String whichWeekDay) {
        this.whichWeekDay = whichWeekDay;
    }

    public String getMealtime() {
        return mealtime;
    }

    public void setMealtime(String mealtime) {
        this.mealtime = mealtime;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(float dishPrice) {
        this.dishPrice = dishPrice;
    }
}
