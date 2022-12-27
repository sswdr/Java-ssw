package com.ssw.test.test;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static class Cat {
        String name;
        Integer age;

        public Cat(String s, int i) {
            this.name = s;
            this.age = i;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}' + "_" + getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Cat> cats = Arrays.asList(new Cat("a", 1), new Cat("b", 1), new Cat("a", 9));
        System.out.println(cats);
        List<Cat> collect = cats.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Cat::getName))), ArrayList::new)
        );
        System.out.println(collect);

    }
}
