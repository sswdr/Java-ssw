package com.ssw.test.test;

import java.util.ArrayList;

/**
 * @Author: ssw
 * @DateTime: 2022/10/12 0:07
 * @Description: TODO
 */
public class test06 {
    public static void main(String[] args) {
        ArrayList<Integer> strings = new ArrayList<>();
        strings.add(1);
        strings.add(2);
        strings.add(3);

        boolean b = strings.stream().anyMatch(s -> s >3);
        System.out.println(b);

    }
}
