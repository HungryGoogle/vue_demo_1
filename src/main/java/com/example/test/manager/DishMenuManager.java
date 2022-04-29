package com.example.test.manager;

import com.example.test.bean.DishBean;
import com.example.test.bean.KeyValueBean;
import com.example.test.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class DishMenuManager {
    boolean tokenIsValidate = false;
    List<DishBean> list = new ArrayList<>();

    public void init(){
        tokenIsValidate = false;
        list.clear();
    }

    public void addDishItem(DishBean dishBean){
        LogUtil.info(dishBean.toString());
        list.add(dishBean);
    }

    List<DishBean> getDishMenu(){
        return list;
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
