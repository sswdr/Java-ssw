package com.ssw.test.hutool.regex;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ssw
 * @date 2022/9/15 14:32
 */
public class DateTestPlus {
    public static void main(String[] args) throws ParseException {

        String reg = "\\d{1,2}/\\d{1,2}/\\d{4}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,6})?";
        System.out.println(reg);

        SimpleDateFormat format03 = new SimpleDateFormat("XXX");
        Date dateXXX = new Date();
        String format = format03.format(dateXXX);
        System.out.println(format);

        SimpleDateFormat format04 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
        Date date = new Date();
        String dateString = format04.format(date);
        System.out.println(dateString);


        List<String> timeReg = Arrays.asList(
                "y", "yy", "yyy", "yyyy",
                "M", "MM",
                "d", "dd",
                "H", "HH",
                "m", "mm",
                "s", "ss",
                "S", "SS", "SSS"
        );
        char[] chars = "yyyy-MM-dd HH:mm:ss".trim().toCharArray();
        String timeRegString = "";
        String symbolString = "";
        String tmp = "";
        for (char chr : chars) {
            if ((chr >= 65 && chr <= 90) || (chr >= 97 && chr <= 122)) {

            } else {

            }

        }

    }
}

