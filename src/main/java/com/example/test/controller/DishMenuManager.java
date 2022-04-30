package com.example.test.controller;

import com.example.test.bean.DishBean;
import com.example.test.bean.KeyValueBean;
import com.example.test.service.DishService;
import com.example.test.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DishMenuManager {
    DishService dishService;
    boolean tokenIsValidate = false;
    int dishCount = 0;

    public void init(DishService _dishService){
        tokenIsValidate = false;
        dishCount = 0;
        dishService = _dishService;
    }

    public void addDishItem(DishBean dishBean){
        LogUtil.info(dishBean.toString());
        if(dishService != null && tokenIsValidate && dishCount < 300) {
            dishService.insertDish(dishBean);
            dishCount++;
        }
    }

    public List<DishBean> queryWeekDishes(){
        if(dishService != null) {
            return dishService.queryWeekDishes();
        }
        return new ArrayList<>();
    }


    // 判断token是否正确
    public int checkTokenInvalidate(KeyValueBean keyValueBean){
        if(keyValueBean == null){
            return 0;
        }

        if("token".equalsIgnoreCase(keyValueBean.getKey())){
            if("RWxJrjJkipZFu6LZZC3vKCloytNAFifuK17ouvSZnZKpRyGcvRWF7EQt9achTWl8xGoE4YHvc2IH8Efar4ZJREzqKi4amVumET3OUChFqulKvw8CZN36V75khda3kd97".equalsIgnoreCase(keyValueBean.getValue())){
                tokenIsValidate = true;
                LogUtil.info("token is validate.");

                // 清空之前的菜单
                dishService.deleteAllDishes();
                return 0;
            }else {
                LogUtil.info("token is invalidate.");
                tokenIsValidate = false;
            }
        }

        return 0;
    }

    // ----------------------------------------------------------------------------
    private static class SingletonInner {
        private static DishMenuManager singletonStaticInner = new DishMenuManager();
    }

    private static boolean  bFirstRun = true;
    public static DishMenuManager getIns() {
        try {
            if(bFirstRun = true) {
                Thread.sleep(1);
                bFirstRun = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return SingletonInner.singletonStaticInner;
    }
}
