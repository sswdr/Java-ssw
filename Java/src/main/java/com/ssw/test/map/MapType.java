package com.ssw.test.map;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ssw
 * @date 2022/9/22 9:36
 */
public class MapType {
    public static void main(String[] args) throws Exception {

        // https://blog.csdn.net/qq_44377709/article/details/125436811

        Map<String, Integer> map = new HashMap<>();
        Class mapClass = map.getClass();
        Method put = mapClass.getMethod("put", Object.class, Object.class);
        put.invoke(map, "Integer对象","Integer对象的value");

        System.out.println(map); //{Integer对象=Integer对象的value}
        System.out.println(String.valueOf(map.get("Integer对象"))); //Integer对象的value
        try {
            System.out.println(map.get("Integer对象")); //Integer对象的value
            System.out.println(map.get("Integer对象").toString()); //java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        }catch (ClassCastException e){
            System.out.println(e);
        }
    }
}
