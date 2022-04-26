package com.example.test.bean;

public class DishBean {
    private int id;
    private String whichWeekDay;    //周几
    private String mealtime;        //餐名，早餐、中餐、晚餐、夜宵
    private String dishName;        //菜名
    private String dishType;        //热菜、凉菜、汤、炖菜
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
