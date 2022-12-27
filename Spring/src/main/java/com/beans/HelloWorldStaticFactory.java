package com.beans;

import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 22:58
 * @Description: TODO
 */
public class HelloWorldStaticFactory {
    // 工厂方法
    public static HelloService newInstance(String message) {
        // 返回需要的Bean实例
        return new HelloBean2(message);
    }
}

