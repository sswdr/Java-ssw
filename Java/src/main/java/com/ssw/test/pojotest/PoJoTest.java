package com.ssw.test.pojotest;

import lombok.*;

/**
 * @author ssw
 * @date 2022/8/18 16:07
 */
@Data
class People {
    private String name;
    private int age;
}

public class PoJoTest {
    public static void main(String[] args) {
        People people1 = new People();
        System.out.println(people1);

        People people2 = new People() { { setAge(1); setName("x"); } };
        System.out.println(people2);
    }
}
