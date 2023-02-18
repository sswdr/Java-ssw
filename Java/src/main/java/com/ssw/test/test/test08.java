package com.ssw.test.test;

import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ssw
 * @date 2023/2/8 15:54
 */
public class test08 {
    public static void main(String[] args) throws InterruptedException {
        String now = DateUtil.now();
        System.out.println(now);

        Date date1 = new Date();
        TimeUnit.SECONDS.sleep(0);
        Date date2 = new Date();

        Calendar nowCalendar = Calendar.getInstance();
        System.out.println(nowCalendar.getTime());
        nowCalendar.add(Calendar.MINUTE,1);
        System.out.println(nowCalendar.getTime());
        nowCalendar.add(Calendar.MINUTE,-1);
        System.out.println(nowCalendar.getTime());




        nowCalendar.clear();
        System.out.println(nowCalendar.getTime());

        /**
         * date1 < date2，返回数小于0，date1==date2返回0，date1 > date2 大于0
         */
        System.out.println(CompareUtil.compare(date1, date2));
        System.out.println(CompareUtil.compare(date2, date2));
        System.out.println(CompareUtil.compare(date2, date1));

        System.out.println(System.currentTimeMillis());
        nowCalendar.add(Calendar.MILLISECOND,1);

        System.out.println(System.currentTimeMillis());
        System.out.println(1/2);

        System.out.println("------------------------------");
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime().getTime());
        TimeUnit.SECONDS.sleep(2);
        System.out.println(calendar.getTime().getTime());
        TimeUnit.SECONDS.sleep(2);
        System.out.println(calendar.getTime().getTime());



    }
}
