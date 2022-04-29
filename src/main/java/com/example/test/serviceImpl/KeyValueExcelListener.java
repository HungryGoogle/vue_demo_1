package com.example.test.serviceImpl;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.test.bean.DishBean;
import com.example.test.bean.KeyValueBean;
import com.example.test.manager.DishMenuManager;
import com.example.test.util.LogUtil;

import java.util.Map;

//读取excel的监听器
public class KeyValueExcelListener extends AnalysisEventListener<KeyValueBean> {

    //一行一行读取Excel内容
    @Override
    public void invoke(KeyValueBean keyValueBean, AnalysisContext analysisContext) {

        DishMenuManager.getIns().checkTokenInvalidate(keyValueBean);
        System.out.println("-->" + keyValueBean);
    }

    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头： " + headMap);
    }

    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println("doAfterAllAnalysed ");
        LogUtil.info("doAfterAllAnalysed...");
    }
}