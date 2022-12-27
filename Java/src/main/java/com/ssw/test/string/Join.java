package com.ssw.test.string;

import java.util.ArrayList;

/**
 * @author ssw
 * @date 2022/9/30 17:59
 */
public class Join {
    public static void main(String[] args) {

        String format = String.format("你好%s,我是%s", "小明", "小黑");
        System.out.println(format);//你好小明,我是小黑

        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("abc");
        listStr.add("ggg");
        String join = String.join(",", listStr);
        System.out.println(join);

    }
}
