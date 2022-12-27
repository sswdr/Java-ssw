package com.ssw.test.gson;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ssw
 * @DateTime: 2022/11/27 21:38
 * @Description: TODO
 */
public class test02 {
    public static void main(String[] args) {

        List<String> list01 = Arrays.asList("1", "2", "4", "3");
        List<String> list02 = new ArrayList<>();
        List<String> list03 = null;

        System.out.println(ListUtils.emptyIfNull(null)); //[]

        for (String s : list02) {
            System.out.println("s"); //不会空指针，不会输出
        }
        for (String s : list03) {
            System.out.println(s); //NullPointerException
        }
        for (String s : ListUtils.emptyIfNull(list03)) {
            System.out.println(); //[]
        }
        for (String s : ListUtils.emptyIfNull(list01)) {
            System.out.print(s); //1243
        }
    }
}
