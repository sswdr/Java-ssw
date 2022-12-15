package com.ssw.test.hutool.regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ssw
 * @date 2022/9/21 11:18
 */
public class StringReg {
    public String getMoney(String str) {
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static void main(String[] args) {
        StringReg stringReg = new StringReg();
        System.out.println(stringReg.getMoney("as%234**2@@f456asdas123d"));


        ArrayList<String> strings = new ArrayList<>();
        System.out.println(strings == null);
        System.out.println(strings.size() == 0);



    }

}
