package com.ssw.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/8/21 17:24
 */
public class GroupingAndCollecting {
    public static void main(String[] args) {
        @Data
        @AllArgsConstructor
        class Person {
            private String name;
            private String city;
        }

        // 创建一个Person列表
        List<Person> persons = Arrays.asList(
                new Person("Alice", "New York"),
                new Person("Bob", "London"),
                new Person("Charlie", "New York"),
                new Person("Dave", "London")
        );

        // 根据城市进行分组，并收集名字
        Map<String, List<String>> groupedNamesByCity = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity,
                        Collectors.mapping(Person::getName, Collectors.toList())));

        System.out.println(groupedNamesByCity); // {New York=[Alice, Charlie], London=[Bob, Dave]}
    }
}
