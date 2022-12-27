package com.beans;

import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/9 0:18
 * @Description: TODO
 */
public class HelloBean4 implements HelloService {
    private String message;
    private int index;
    //setter方法
    public void setMessage(String message) {
        this.message = message;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }
}

