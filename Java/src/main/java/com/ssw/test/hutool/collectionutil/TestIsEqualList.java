package com.ssw.test.hutool.collectionutil;

import cn.hutool.core.collection.CollectionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class TestIsEqualList {

    @Data
    @AllArgsConstructor
    public static class Person {
        private String name;
        private int age;
        private boolean isMale;
        private List<String> hobbies;
    }

    public static void main(String[] args) {

        List<String> list01 = Arrays.asList("a", "b", "c", "d");
        List<String> list02 = Arrays.asList("b", "a", "c", "d");
        List<String> list03 = Arrays.asList("a", "b", "c", "d");
        List<Person> person01 = Arrays.asList(
                new Person("name01", 1, true, list01),
                new Person("name02", 2, true, list01)
        );
        List<Person> person02 = Arrays.asList(
                new Person("name02", 2, true, list02),
                new Person("name01", 1, true, list02)
        );

        /**
         * 判断两个集合是否元素和顺序相同：cn.hutool.core.collection.CollectionUtil.isEqualList()
         *  两个Collection必须长度相同
         *  两个Collection元素相同index的对象必须equals，满足Objects.equals(Object, Object)
         */
        System.out.println(CollectionUtil.isEqualList(list01, list02)); //false
        System.out.println(CollectionUtil.isEqualList(list01, list03)); //true

        /**
         * 判断两个集合交集：cn.hutool.core.collection.CollectionUtil.intersection()
         * 多个集合的交集 针对一个集合中存在多个相同元素的情况，计算两个集合中此元素的个数，保留最少的个数
         * 例如：集合1：[a, b, c, c, c]，集合2：[a, b, c, c]
         * 结果：[a, b, c, c]，此结果中只保留了两个c
         * 交集的集合，返回 ArrayList
         */
        Collection<String> intersection = CollectionUtil.intersection(list01, list02);
        System.out.println(intersection); //[a, b, c, d]

        /**
         * 如何得到两个集合内容是否相等？
         *  1.求交集。判断三个集合长度是否相等
         *  2.对两个集合集合先按照集合内的东西用hash排序，然后用toString方法，最后比较两个两个toString是否相同。
         */
        list01.sort(Comparator.comparingLong(String::hashCode));
        list02.sort(Comparator.comparingLong(String::hashCode));
        System.out.println(list01.toString().equals(list02.toString())); //true

        person01.sort(Comparator.comparingLong(Person::hashCode));
        person02.sort(Comparator.comparingLong(Person::hashCode));
        System.out.println(person01.toString().equals(person02.toString())); //true,Person类必须提供get和set方法,否则是false
    }
}
