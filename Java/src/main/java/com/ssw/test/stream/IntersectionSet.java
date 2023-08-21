package com.ssw.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/8/21 18:07
 */
public class IntersectionSet {
    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        lists.add(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        lists.add(list2);

        List<String> set = lists.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .filter(y -> y.getValue() >= lists.size())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(set); // [b]
    }
}
