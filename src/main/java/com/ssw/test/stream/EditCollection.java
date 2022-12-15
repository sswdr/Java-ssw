package com.ssw.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2022/10/12 14:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
class People {
    private String name;
    private int age;
}

public class EditCollection {
    public static void main(String[] args) {
        // stream遍历修改集合
        List<People> list = Arrays.asList(new People("111", 222), new People("333", 444));
        System.out.println("list01: \t\t" + list + "\n"); //[People(name=111, age=222), People(name=333, age=444)]

        List<People> mapEditList = list.stream().map(s -> {
            if ("333".equals(s.getName())) {
                s.setAge(666);
            }
            return s;
        }).collect(Collectors.toList());
        System.out.println("list02: \t\t" + list); //[People(name=111, age=222), People(name=333, age=666)]
        System.out.println("mapEditList: \t" + mapEditList); //[People(name=111, age=222), People(name=333, age=666)]

        List<People> peekEditList = list.stream().peek(s -> {
            if ("333".equals(s.getName())) {
                s.setAge(777);
            }
        }).collect(Collectors.toList());
        System.out.println("list03: \t\t" + list); //[People(name=111, age=222), People(name=333, age=777)]
        System.out.println("peekEditList: \t" + peekEditList); //[People(name=111, age=222), People(name=333, age=777)]

        list.forEach(s->{
            if("333".equals(s.getName())){
                s.setAge(888);
            }
        });
        System.out.println("list04: \t\t" + list); //[People(name=111, age=222), People(name=333, age=888)]
        System.out.println("forEditList: \t" + peekEditList); //[People(name=111, age=222), People(name=333, age=888)]

    }
}
