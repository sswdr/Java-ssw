package com.ssw.test.hutool.regex;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author ssw
 * @date 2022/9/15 14:32
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        String timeStr01 = "1/1/2022 10:10:10";
        String timeStr02 = "2022-01-01 10:10:10";
        String timeStr03 = "fk2022-01-01 10:10:10";

        DateTime dateTime01 = DateUtil.parseDate(timeStr01);
        System.out.println(dateTime01);

        DateTime dateTime02 = DateUtil.parseDate(timeStr02);
        System.out.println(dateTime02);

        // hutool：DateUtil.parseDate：穷举法解析字符串为日期，不是日期则抛异常
        try {
            DateTime dateTime03 = DateUtil.parseDate(timeStr03);
            System.out.println(dateTime03);
        } catch (Exception e) {
            System.out.println("解析异常了，异常为：" + e.getClass().getSimpleName());
        }

        SimpleDateFormat format01 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        SimpleDateFormat format02 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date formatTime01 = format01.parse(timeStr01);
        System.out.println(formatTime01);

        Date formatTime02 = format02.parse(timeStr02);
        System.out.println(formatTime02);

        // hutool：ReUtil正则相关工具类、DatePattern日期格式化类，提供常用的日期格式化对象
        // 常量DatePattern.REGEX_NORM：Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,6})?");
        System.out.println("(ReUtil.isMatch(DatePattern.REGEX_NORM, \"2022-01-01 10:10:10\")："
                + ReUtil.isMatch(DatePattern.REGEX_NORM, "2022-01-01 10:10:10"));

        // 推荐做法，参照DatePattern.REGEX_NORM，解析 MM/dd/yyyy HH:mm:ss
        Pattern compile = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,6})?");
        System.out.println("(ReUtil.isMatch(DatePattern.REGEX_NORM, \"1/1/2022 10:10:10\")："
                + ReUtil.isMatch(compile, "1/1/2022 10:10:10"));
    }
}