package com.ssw.test.hutool.beanutil;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author ssw
 * @date 2022/9/15 15:11
 */
public class test {
    @Data
    public static class Cat {
        String name;
        Integer age;
    }

    @Data
    public static class Dog {
        String name;
        Integer age;
        String dogName;
    }

    public static void main(String[] args) throws Exception {
        String name = "name";
        String age = "age";

        Cat cat = new Cat();
        BeanUtil.setProperty(cat, name, "nb猫");
        BeanUtil.setProperty(cat, age, "1");
        System.out.println(cat);

        Class<Cat> catClass00 = Cat.class;
        Class catClass01 = cat.getClass();
        Class<? extends Cat> catClass02 = cat.getClass();

        Field declaredField = catClass01.getDeclaredField(name);
        System.out.println(declaredField);
        Class<?> type = catClass01.getDeclaredField(name).getType();
        System.out.println(type);

        /*
         * 通过 Class 类的 newInstance() 方法创建对象，该方法要求该 Class 对应类有无参构造方法。
         * 执行 newInstance()方法实际上就是使用对应类的无参构造方法来创建该类的实例，其代码的作用等价于Super sup = new Super()。
         * 如果 Super 类没有无参构造方法，运行程序时则会抛出一个 InstantiationException 实例化异常。
         */
        Object cat01 = catClass01.newInstance();
        System.out.println(cat01);
        Cat cat02 = catClass02.newInstance();
        System.out.println(cat02);

        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println("methodName：" + methodName);
        Method methodByCatClass01ForName = catClass01.getDeclaredMethod(methodName, catClass01.getDeclaredField(name).getType());
        methodByCatClass01ForName.invoke(cat01,"会反射的猫1");
        System.out.println(cat01);
        methodByCatClass01ForName.invoke(cat02,"会反射的猫2");
        System.out.println(cat02);
        Method methodByCatClass02ForName = catClass02.getDeclaredMethod(methodName, catClass01.getDeclaredField(name).getType());
        methodByCatClass02ForName.invoke(cat01,"会反射的猫3");
        System.out.println(cat01);
        methodByCatClass02ForName.invoke(cat02,"会反射的猫4");
        System.out.println(cat02);

        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(cat);
        System.out.println(stringObjectMap);
        Dog dog = new Dog();
        BeanUtil.copyProperties(cat,dog);
        System.out.println(dog);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(dog);
        objects.add(cat);
        System.out.println(objects);
        Map<String, Object> stringObjectMap1 = BeanUtil.beanToMap(objects);
        System.out.println(stringObjectMap1);


    }
}
