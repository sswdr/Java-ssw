package com.ssw.test;

import cn.hutool.core.lang.id.NanoId;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


/**
 * @author ssw
 * @date 2022/7/28 16:43
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(NanoId.randomNanoId(4));

        Boolean aBoolean = new Boolean(true);
        System.out.println(aBoolean);

        long time = new Date().getTime();
        System.out.println(time);

        LocalDateTime stampToLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
        int minute = stampToLocalDateTime.getMinute();
        System.out.println(minute);

        System.out.println(time/1000000/60);
    }
}
