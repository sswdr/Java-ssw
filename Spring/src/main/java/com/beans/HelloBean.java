package com.beans;
import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 22:48
 * @Description: TODO
 */
public class HelloBean implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}

