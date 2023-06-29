package com.ssw.test.reflex;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/6/29 14:26
 */
public class getObjectFiledCollection {
    public static void main(String[] args) {
        System.out.println(People.catNames);  //[name, age, gender]
    }
}

@Data
class Cat {
    private String name;
    private int age;
    private String gender;
}

@Data
class People {
    private String name;
    private int age;

    public final static List<String> catNames;
    static {
        /*
         * 获取对象的属性集合
         * @param clazz 反射的对象class
         * @return 对象属性集合
         */
        catNames = Arrays.stream(Cat.class.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
    }
}
