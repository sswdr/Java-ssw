package com.ssw.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/2/18 16:08
 */
public class ListCollectCount {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("abc", "abc", "abc", "abc", "acb", "bac");
        Map<String, Long> countMap = list.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println(countMap); //{acb=1, abc=4, bac=1}

    }
}
