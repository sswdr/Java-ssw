package com.beans;

import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 22:50
 * @Description: TODO
 */
public class HelloBean2 implements HelloService {
    private String message;

    @Override
    public void sayHello() {
        System.out.println(message);
    }
    public HelloBean2() {
        this.message = "Hello World!";
    }
    public HelloBean2(String message) {
        this.message = message;
    }
}

