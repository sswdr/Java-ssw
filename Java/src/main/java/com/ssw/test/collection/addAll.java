package com.ssw.test.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ssw
 * @date 2023/6/29 14:22
 */
public class addAll {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        List<String> list2 = new ArrayList<>();
        list.add("a");
        list.add("c");

        List<String> list3 = null;

        Set<String> set = new HashSet<>();

        set.addAll(list);
        set.addAll(list2);
        //set.addAll(list3); //NullPointerException

        System.out.println(set);
    }
}
