package com.ssw.test.time;

import cn.hutool.core.date.DateTime;

import javax.swing.text.DateFormatter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ssw
 * @date 2022/8/2 14:23
 */
public class LocalDateTimeTest {
    public static void main(String[] args) throws Exception {
        /**
         * 1.LocalDateTime -> 字符串 yyyy-MM-dd HH:mm:ss
         */
        String nowLocalDateTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(nowLocalDateTimeString); //2022-10-12 11:04:38

        /**
         * 2.字符串 yyyy-MM-dd HH:mm:ss -> LocalDateTime
         */
        LocalDateTime localDateTime = LocalDateTime.parse("2022-10-12 10:59:19", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime); //2022-10-12T10:59:19

        /**
         * 3.LocalDateTime -> long时间戳,默认毫秒级13位
         */
        ZoneOffset set = OffsetDateTime.now(ZoneId.systemDefault()).getOffset(); //时区ZoneOffset：+08:00
        Instant nowLocalDateTimeInstant = LocalDateTime.now().toInstant(set);  //Instant时间戳：Wed Oct 12 11:04:38 CST 2022
        long nowLocalDateTimeStamp = nowLocalDateTimeInstant.toEpochMilli(); //1665543878000

        /**
         * 4.long时间戳,秒级10位 -> LocalDateTime
         *  秒级对应Instant.ofEpochSecond()
         *  毫秒对应Instant.ofEpochMilli()
         */
        long stamp = 1663322105L;
        LocalDateTime stampToLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(stamp), ZoneId.systemDefault());
        System.out.println(stampToLocalDateTime); //2022-09-16T17:55:05

        /**
         * 5.字符串 yyyy-MM-dd HH:mm:ss -> long时间戳,默认毫秒级13位
         */
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-10-12 11:04:38"); //Wed Oct 12 11:04:38 CST 2022
        long stampTime = date.getTime(); //1665543878000

        /**
         * 6.long时间戳,默认毫秒级13位 -> 字符串 yyyy-MM-dd HH:mm:ss
         */
        long timeStamp = new Date().getTime(); //1665545651250
        String timeText = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeStamp); //2022-10-12 11:35:24

        // 取系统ZoneOffset、ZoneId
        ZoneId zoneId = ZoneId.systemDefault(); //Asia/Shanghai
        ZoneOffset offset = OffsetDateTime.now(ZoneId.systemDefault()).getOffset(); //+08:00

        LocalDateTime nowLocalDateTime = LocalDateTime.now(); //2022-10-12T11:04:38.111
        LocalDate nowLocalDate = LocalDate.now(); //2022-10-12

        // SimpleDateFormat默认多线程，线程不安全
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 线程安全：DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
