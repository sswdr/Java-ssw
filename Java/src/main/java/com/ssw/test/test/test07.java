package com.ssw.test.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/2/6 18:02
 */
public class test07 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "1");

        Set<String> collect = strings.stream().collect(Collectors.toSet());
        System.out.println(collect);


    }
}
