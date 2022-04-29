package com.example.test.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class KeyValueBean {
    @ExcelProperty(value = "key",index = 0)
    String key;
    @ExcelProperty(value = "value",index = 1)
    String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
