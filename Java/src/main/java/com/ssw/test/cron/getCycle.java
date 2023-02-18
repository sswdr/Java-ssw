package com.ssw.test.cron;

import com.jn.langx.util.timing.cron.CronExpressions;

import java.util.Date;

/**
 * @author ssw
 * @date 2023/2/18 16:41
 */
public class getCycle {
    public static void main(String[] args) {
        // 0 0/2 * * * ?    表示每2分钟 执行任务
        System.out.println(getCronCycleTime("0 0/2 * * * ?")); //120
    }

    /**
     * @param cron 表达式字符串
     * @return 单位s
     */
    private static Integer getCronCycleTime(String cron) {
        Date now = new Date();
        Date start = CronExpressions.nextTime(cron, now);
        Date end = CronExpressions.nextTime(cron, start);
        return (int) (end.getTime() - start.getTime()) / 1000;
    }
}
