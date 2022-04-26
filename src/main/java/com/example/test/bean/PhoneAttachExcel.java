package com.example.test.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneAttachExcel{
    @ExcelProperty(index = 0,value = "联络标识")
    private String contract_id;
 
    @ExcelProperty(index = 1,value = "录音地址")
    private String url;
 
//    这个参数没有用到  存放什么都行
    @ExcelProperty(index = 2,value = "手机号")
    private String phone;
}