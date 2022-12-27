package com.beans;

import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 23:21
 * @Description: TODO
 */
public class instanceFactory {
    public HelloService newInstance(String message, int index) {
        return new HelloBean3(message, index);
    }

}
