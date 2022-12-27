package com.ssw.test.time;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ssw
 * @date 2022/9/16 14:03
 */
public class TimeUnitTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);
        long l = TimeUnit.MILLISECONDS.toSeconds(time);
        System.out.println(l);

        System.out.println(LocalDateTime.now());
        LocalDateTime now = LocalDateTime.now();


    }
}
