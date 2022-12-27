package com.beans;

import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 23:00
 * @Description: TODO
 */
public class HelloWorldFactory {
    // 工厂方法
    public HelloService newInstance2(String message) {
        // 返回需要的Bean实例
        return new HelloBean2(message);
    }
}

