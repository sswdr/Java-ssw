package com.ssw.test.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/8/21 17:23
 */
public class TwoListMergeToMap {
    public static void main(String[] args) {
        // list 转 map
        Map<String, String> map = new HashMap<>();
        map.put("a", "abc");
        map.put("b", "bcd");
        map.put("h", "hij");

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("h");

        Map<String, List<String>> res = list.stream().distinct()
                .collect(Collectors.groupingBy(x -> x, Collectors.mapping(map::get, Collectors.toList())));
        System.out.println(res); // {a=[abc], b=[bcd], h=[hij]}
    }
}
