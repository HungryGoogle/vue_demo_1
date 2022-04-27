package com.example.test.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DishTokenBean
{
    //设置Excel表头名称
    @ExcelProperty(value = "名字",index = 0)
    private String itemName;

    @ExcelProperty(value = "值",index = 1)
    private String itemValue;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}