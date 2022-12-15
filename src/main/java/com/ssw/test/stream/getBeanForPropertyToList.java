package com.ssw.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date= 2022/10/11 11:22
 * @Desc stream取list对象单一属性的list字符串集合
 */
public class getBeanForPropertyToList {
    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(new Dish("001", 100, false), new Dish("002", 200, true));
        System.out.println(dishes);  //[Dish(name=001, calories=100, isVegetable=false), Dish(name=002, calories=200, isVegetable=true)]
        List<String> collect = dishes.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(collect);  //[001, 002]
    }
}
