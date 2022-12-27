package com.ssw.test.test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: ssw
 * @DateTime: 2022/9/15 23:55
 * @Description: TODO
 */
public class test05 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        long nowLocalDateTimeStamp = now.toInstant(OffsetDateTime.now(ZoneId.systemDefault()).getOffset()).toEpochMilli();
        System.out.println("nowLocalDateTimeStamp:\t\t\t"+nowLocalDateTimeStamp+"\n");
    }
}
