package com.ssw.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2022/10/19 15:50
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
class Cat {
    private String name;
    private int age;
}

public class grouping {
    public static void main(String[] args) {
        List<Cat> list = Arrays.asList(
                new Cat("cat-01", 1),
                new Cat("cat-01", 2),
                new Cat("cat-02", 3),
                new Cat("cat-03", 0)
        );
        // System.out.println(list); //[Cat(name=cat-01, age=1), Cat(name=cat-01, age=2), Cat(name=cat-02, age=3)]
        // Map<String, List<Cat>> result = list.stream().collect(Collectors.groupingBy(Cat::getName));
        // System.out.println(result); //{cat-01=[Cat(name=cat-01, age=1), Cat(name=cat-01, age=2)], cat-02=[Cat(name=cat-02, age=3)]}

        System.out.println(list); //[Cat(name=cat-01, age=1), Cat(name=cat-01, age=2), Cat(name=cat-02, age=3), Cat(name=cat-03, age=0)]
        List<Cat> sort = list.stream().sorted(Comparator.comparing(Cat::getAge)).collect(Collectors.toList());
        System.out.println(sort); //[Cat(name=cat-03, age=0), Cat(name=cat-01, age=1), Cat(name=cat-01, age=2), Cat(name=cat-02, age=3)]
    }
}
