package com.ssw.test.jdk8;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @author ssw
 * @date 2022/7/29 10:12
 */
public class People {
    private Integer age;

    People(){
        System.out.println(age);
    }

    public static void main(String[] args) {
        //创建Supplier容器，声明为TestSupplier类型，此时并不会调用对象的构造方法，即不会创建对象
        Supplier<People> sup= People::new;
        //调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        People people = sup.get();
        System.out.println("people.age: " + people.age);
        //每次get都会调用构造方法，即获取的对象不同
        sup.get();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.forEach(string -> string.toLowerCase().toString());
    }
}
