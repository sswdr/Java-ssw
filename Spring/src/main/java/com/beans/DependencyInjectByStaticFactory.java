package com.beans;

import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 23:14
 * @Description: TODO
 */
public class DependencyInjectByStaticFactory {
    public static HelloService newInstance(String message, int index) {
        return new HelloBean3(message, index);
    }
}

