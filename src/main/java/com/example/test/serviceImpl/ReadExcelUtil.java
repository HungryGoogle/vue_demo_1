package com.example.test.serviceImpl;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.test.bean.PhoneAttachExcel;

import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtil extends AnalysisEventListener<PhoneAttachExcel> {
//    定义一个list,存放excel解读出来的数据
    public List<PhoneAttachExcel> list =new ArrayList<>();
//    解析完一行，就会执行这个方法
    @Override
    public void invoke(PhoneAttachExcel data, AnalysisContext context) {
        list.add(data);
    }
 
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
 
    }
}