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
    List<DishBean> list = new ArrayList<>();

    public void init(DishService _dishService){
        tokenIsValidate = false;
        list.clear();
        dishService = _dishService;
    }

    public void addDishItem(DishBean dishBean){
        LogUtil.info(dishBean.toString());
//        list.add(dishBean);

        dishService.insertDish(dishBean);
    }

    public List<DishBean> queryWeekDishes(){
//        return list;
        return dishService.queryWeekDishes();
    }


    // 判断token是否正确
    public int checkTokenInvalidate(KeyValueBean keyValueBean){
        if(keyValueBean == null){
            return 0;
        }

        if("token".equalsIgnoreCase(keyValueBean.getKey())){
            if("tokenValue".equalsIgnoreCase(keyValueBean.getValue())){
                tokenIsValidate = true;
                LogUtil.info("token is validate.");
//                dishService.deleteAllDishes();
                return 0;
            }else {
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
