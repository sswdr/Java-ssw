package com.ssw.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * @author ssw
 * @date 2022/10/25 16:59
 */
public class SortDemo {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Dog{
        String name;
        Integer age;
    }

    @Test
    public void test01() {
        // // Integer的compareTo()方法
        // Integer integer = 5;
        // System.out.println(integer.compareTo(4)); //1
        // System.out.println(integer.compareTo(5)); //0
        // System.out.println(integer.compareTo(6)); //-1

        HashMap<String, Integer> data = new HashMap<String, Integer>() {{
            put("g", 0);put("b", 1);put("c", 7);put("z", 9);
            put("a", 3);put("e", 2);put("f", 5);put("d", -1);
        }}; //{a=3, b=1, c=7, d=-1, e=2, f=5, g=0, z=9}
        Set<Map.Entry<String, Integer>> dateEntries = data.entrySet(); //[a=3, b=1, c=7, d=-1, e=2, f=5, g=0, z=9]

        // Map -> Map [Map按键或值进行排序] 倒序：{z=9, c=7, f=5, a=3, e=2, b=1, g=0, d=-1}
        Map<String, Integer> sort01 = data.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        System.out.println(sort01); //{z=9, c=7, f=5, a=3, e=2, b=1, g=0, d=-1}

        // Map -> Map [Map按键或值进行排序] 正序 comparingByValue()
        Map<String, Integer> sort02 = data.entrySet().stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        System.out.println(sort02); //{d=-1, g=0, b=1, e=2, a=3, f=5, c=7, z=9}

        // Map -> Bean [Map按键或值进行排序,并且取前5]
        List<Dog> sort03 = data.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .map(entry -> new Dog(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        System.out.println(sort03); //[SortDemo.Dog(name=z, age=9), SortDemo.Dog(name=c, age=7), SortDemo.Dog(name=f, age=5), SortDemo.Dog(name=a, age=3), SortDemo.Dog(name=e, age=2)]

        HashMap<String, Integer> tmp = new HashMap<>((int) Math.ceil((data.size() / 0.75) + 1));

        LinkedHashMap<String, Integer> sort04 = data.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

        TreeMap<String, Integer> sort05 = data.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, TreeMap::new));


    }

}
