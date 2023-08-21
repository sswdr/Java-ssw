package com.ssw.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/8/21 17:03
 */
public class mergedList {
    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("a","b"));
        lists.add(Arrays.asList("b","c"));

        List<String> mergedList = lists.stream()
                .flatMap(List::stream) // 将每个集合扁平化为单个流
                .distinct() // 去重
                .collect(Collectors.toList()); // 收集结果为List集合

        System.out.println(mergedList); // [a, b, c]
    }
}
