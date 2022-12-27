package com.beans;

import com.services.HelloService;

/**
 * @Author: ssw
 * @DateTime: 2021/12/9 0:21
 * @Description: TODO
 */
public class HelloApiDecorator implements HelloService {
    private HelloService helloApi;
    // 空参构造器
    public HelloApiDecorator() {
    }
    // 有参构造器
    public HelloApiDecorator(HelloService helloApi) {
        this.helloApi = helloApi;
    }
    public void setHelloApi(HelloService helloApi) {
        this.helloApi = helloApi;
    }
    @Override
    public void sayHello() {
        System.out.println("==========装饰一下===========");
        helloApi.sayHello();
        System.out.println("==========装饰一下===========");
    }
}
