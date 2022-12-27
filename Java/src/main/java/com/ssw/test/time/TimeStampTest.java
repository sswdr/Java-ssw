package com.ssw.test.time;

import cn.hutool.core.date.DateTime;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

/**
 * @author ssw
 * @date 2022/9/20 10:21
 */
public class TimeStampTest {
    public static void main(String[] args) {

        Instant nowLocalDateTimeInstant = LocalDateTime.now().toInstant(OffsetDateTime.now(ZoneId.systemDefault()).getOffset());
        long nowLocalDateTimeStamp = nowLocalDateTimeInstant.toEpochMilli();
        System.out.println(nowLocalDateTimeStamp);  // 13位毫秒级时间戳 1663640926780

        DateTime now = new DateTime();
        System.out.println(now.getTime());  // 13位毫秒级时间戳 1663640926780

        // java.sql.Timestamp
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp);  // 2022-09-20 10:32:01.5202772

        long time = timestamp.getTime();
        System.out.println(time);  // 13位毫秒级时间戳 1663640926780

        // ck如果使用秒级日期属性字段：Datetime接受年-月-日 时:分:秒的字符串，比如2019-12-16 20:50:10
        // 那么对应Java如果使用时间戳的lang字符串数字（13位时间戳）作为检索条件，可能会出错（数据库的10为的时间戳）
        // 解决方案：Java获取10位时间戳（java.util.concurrent.TimeUnit）
        // eg：获取当前时间的10位秒级时间戳
        long seconds = TimeUnit.MILLISECONDS.toSeconds(Timestamp.valueOf(LocalDateTime.now()).getTime());
        System.out.println(seconds);  // 10位毫秒级时间戳 1663640926
    }
}
