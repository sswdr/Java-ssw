package com.beans;

import java.util.List;

/**
 * @Author: ssw
 * @DateTime: 2021/12/9 0:19
 * @Description: TODO
 */
public class ListTestBean {
    private List<String> values;
    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }
    public void sayHello() {
        System.out.println(values.toString());

    }
}

