package com.ssw.test.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2022/10/12 10:31
 */
public class SummarizingInt {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(2);
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(value -> value));
        // IntSummaryStatistics collect：IntSummaryStatistics{count=3, sum=12, min=2, average=4.000000, max=7}
        System.out.println("IntSummaryStatistics collect：" + collect);
        System.out.println("统计集合元素的个数（long）：" + collect.getCount());  // 统计集合元素的个数（long）：3
        System.out.println("集合元素累加之和（long）：" + collect.getSum());  // 集合元素累加之和（long）：12
        System.out.println("集合中最小值（int）：" + collect.getMax());  // 集合中最小值（int）：7
        System.out.println("集合中最大值（int）：" + collect.getMin());  // 集合中最大值（int）：2
        System.out.println("集合中平均值（double）：" + collect.getAverage());  // 集合中平均值（double）：4.0
    }
}
