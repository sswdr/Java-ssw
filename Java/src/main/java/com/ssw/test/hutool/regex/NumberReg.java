package com.ssw.test.hutool.regex;

import java.util.regex.Pattern;

/**
 * @author ssw
 * @date 2022/9/22 9:35
 */
public class NumberReg {
    public static void main(String[] args) {

        String str = "safcds4d%!@#$%^&*/5/_.6";
        String numStr = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        System.out.println(numStr); // 456

    }
}
