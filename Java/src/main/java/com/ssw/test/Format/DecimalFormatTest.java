package com.ssw.test.Format;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author ssw
 * @date 2022/10/12 10:31
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        double num = 1789871;
        DecimalFormat df = new DecimalFormat("#.#");
        /**
         * 指定RoundingMode
         *    HALF_UP — 四舍五入
         *    HALF_DOWN — 五舍六入
         *    DOWN — 直接截断
         *    UP — 始终对非零舍弃部分前面的数字加 1
         */
        df.setRoundingMode(RoundingMode.DOWN);
        String str = df.format(num);
        System.out.println(str);
        double formatNum = Double.parseDouble(str);
        System.out.println(formatNum);

        /**
         * 0表示数字占位符，实际位数不够时补零
         * 比实际数字的位数多，不足的地方用0补上
         */
        String format = new DecimalFormat("00.000").format(3.14); //结果：03.14
        System.out.println(format);
        format = new DecimalFormat("00.00").format(3.14); //结果：03.14
        System.out.println(format);
        format = new DecimalFormat("0.000").format(3.14); //结果： 3.140
        System.out.println(format);
        format = new DecimalFormat("00.000").format(3.14); //结果：03.140
        System.out.println(format);
        /**
         * 整数部分比实际数字的位数少，整数部分不改动
         * 小数部分比实际数字的位数少，根据小数部分占位符数量保留小数
         */
        format = new DecimalFormat("0.000").format(13.146); //结果：13.146
        System.out.println(format);
        format = new DecimalFormat("00.00").format(13.146); //结果：13.15
        System.out.println(format);
        format = new DecimalFormat("0.00").format(13.146); //结果：13.15
        System.out.println(format);


        /**
         * #表示数字占位符，实际位数不够时不补零
         * 比实际数字的位数多，不变
         */
        format = new DecimalFormat("##.##").format(3.14);
        System.out.println(format); //结果：3.14
        format = new DecimalFormat("#.###").format(3.14);
        System.out.println(format); //结果： 3.14
        format = new DecimalFormat("##.###").format(3.14);
        System.out.println(format); //结果：3.14
        /**
         * 整数部分比实际数字的位数少，整数部分不改动
         * 小数部分比实际数字的位数少，根据小数部分占位符数量保留小数
         */
        format = new DecimalFormat("#.###").format(13.146);
        System.out.println(format); //结果：13.146
        format = new DecimalFormat("##.##").format(13.146);
        System.out.println(format); //结果：13.15
        format = new DecimalFormat("#.##").format(13.146);
        System.out.println(format); //结果：13.15
    }
}
