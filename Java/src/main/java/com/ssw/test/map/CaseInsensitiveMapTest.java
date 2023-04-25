package com.ssw.test.map;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ssw
 * @date 2023/4/25 11:32
 * @desc CaseInsensitiveMap：不區分KEY大小寫的MAP
 */
public class CaseInsensitiveMapTest {
    public static void main(String[] args) {

        // 不區分KEY大小寫的MAP
        Map<String, Object> resultCaseInsensitiveMap = new CaseInsensitiveMap<>();
        resultCaseInsensitiveMap.put("Aa", 123);
        System.out.println(resultCaseInsensitiveMap);
        System.out.println(resultCaseInsensitiveMap.get("AA"));
        System.out.println(resultCaseInsensitiveMap.get("aA"));
        System.out.println(resultCaseInsensitiveMap.get("aa"));
        resultCaseInsensitiveMap.put("AA", 456);
        System.out.println(resultCaseInsensitiveMap + "\n");

        // 而HashMap是要區分大小寫的ge
        Map<String, Object> resultHashMap = new HashMap<>();
        resultHashMap.put("Aa", 123);
        System.out.println(resultHashMap);
        System.out.println(resultHashMap.get("AA"));
        System.out.println(resultHashMap.get("aA"));
        System.out.println(resultHashMap.get("aa"));
        resultHashMap.put("AA", 456);
        System.out.println(resultHashMap + "\n");

        // 若須要把HashMap轉爲CaseInsensitiveMap，須要putAll，直接等因而不生效的。class
        // 正確：map
        resultCaseInsensitiveMap.putAll(resultHashMap);
        // 錯誤：static
        resultCaseInsensitiveMap = resultHashMap;  // 不生效，依舊區分大小寫
    }
}
