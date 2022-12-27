package com.ssw.test.escape;

import java.util.stream.Stream;

/**
 * @author ssw
 * @date 2022/9/22 15:28
 */
public class EscapeString {
    public static void main(String[] args) {
        String str = " ?? 12%3_4__5";
        StringBuilder res = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if(aChar == '%' || aChar == '_'){
                System.out.println(aChar);
                res.append("\\\\");
            }
            res.append(aChar);
        }
        System.out.println(str);
        System.out.println(res);

        Stream.of(chars).forEach(aChar -> {
            if(aChar.equals("%") || aChar.equals('_')){
                res.append("\\\\");
            }
            res.append(aChar);
        });
        System.out.println(str);
        System.out.println(res);

        System.out.println("\\");
    }
}
