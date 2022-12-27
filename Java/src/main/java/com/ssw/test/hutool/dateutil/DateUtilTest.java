package com.ssw.test.hutool.dateutil;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author ssw
 * @date 2022/10/12 16:11
 */
public class DateUtilTest {
    public static void main(String[] args) {
        String dateString = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateString); //2022-10-12 16:13:33
    }
}
