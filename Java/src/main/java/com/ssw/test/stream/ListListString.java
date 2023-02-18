package com.ssw.test.stream;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ssw
 * @date 2023/2/18 16:19
 */
public class ListListString {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("1,2,3", "4,5,6", "7,8,9,10,0","1,1,1");

        //方式一，效率大于方式二
        List<String> listListString = new ArrayList<>(list.size());
        List<String> finalListListString = listListString;
        list.forEach(x-> finalListListString.addAll(Arrays.asList(StringUtils.splitString(x, ","))));
        System.out.println(listListString); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 1, 1]
        Map<String, Long> listListStringMap = listListString.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(listListStringMap); //{0=1, 1=4, 2=1, 3=1, 4=1, 5=1, 6=1, 7=1, 8=1, 9=1, 10=1}

        //方式二
        List<List<String>> listList = list.stream().map(x -> Arrays.asList(StringUtils.splitString(x, ","))).collect(Collectors.toList());
        System.out.println(listList); //[[1, 2, 3], [4, 5, 6], [7, 8, 9, 10, 0]]
        Object collect = Stream.of(listList.toArray(new List[]{})).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect.getClass()); //class java.util.ArrayList
        System.out.println(collect); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 1, 1]
        listListString = (List<String>) collect;
        listListStringMap = listListString.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(listListStringMap); //{0=1, 1=4, 2=1, 3=1, 4=1, 5=1, 6=1, 7=1, 8=1, 9=1, 10=1}
    }
}
