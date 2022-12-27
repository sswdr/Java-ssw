package com.ssw.test.test;

/**
 * @Author: ssw
 * @DateTime: 2021/10/17 22:38
 * @Description: 单例模式
 */
public class test02 {

    private volatile static test02 instance = null;

    /**
     * 构造方法私有化，防止外部new出来实例对象
     */
    private test02(){ }

    public static synchronized test02 getInstance() {
        if (instance == null) {
            synchronized (test02.class) {
                if (instance == null) {
                    instance = new test02();
                }
            }
        }
        return instance;
    }
}