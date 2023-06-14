package com.ssw.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ssw
 * @date 2023/6/14 11:35
 */
public class getOrDefaultMap {
    public static void main(String[] args) {
        Map<String, Map<String, String>> map = new HashMap<>();
        map.put("a", new HashMap<>());
        map.put("b", null);

        System.out.println(map); //{a={}, b=null}
        System.out.println(map.getOrDefault("a", new HashMap<>())); //{}
        System.out.println(map.getOrDefault("b", new HashMap<>())); //null
        System.out.println(map.getOrDefault("c", new HashMap<>())); //{}
    }
}
