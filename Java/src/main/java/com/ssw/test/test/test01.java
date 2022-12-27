package com.ssw.test.test;

public class test01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 字符串中第二大的数字
     *
     * @param s string字符串 字符串
     * @return int整型
     */
    public static int secondHighest(String s) {

        char[] a = s.toCharArray();
        int secondHighest = 0;
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            if ((int) a[i] > 48 && (int) a[i] <= 58) {
                if ((a[i] - '0') > max) {
                    max = (a[i] - '0');
                }
            }
        }

        String s2 = String.valueOf(max);
        String s1 = s.replaceAll(s2, "");
        char[] s3 = s1.toCharArray();

        for (int i = 0; i < s3.length; i++) {
            if ((int) s3[i] > 48 && (int) s3[i] <= 58) {
                if ((s3[i] - '0') > secondHighest) {
                    secondHighest = (s3[i] - '0');
                }
            }
        }


        if (secondHighest == max) {
            return -1;
        }


        return secondHighest;
    }

    public static void main(String[] args) {
        System.out.println("secondHighest: " + test01.secondHighest("a077"));
    }
}

//    public static int secondHighest(String s) {
//
//        char[] a = s.toCharArray();
//        int secondHighest = 48;
//        int max = 48;
//        int flat = 0;
//
//        for (char c : a) {
//            if ((int) c >= 48 && (int) c <= 58) {
//                if ((int) c > max) {
//
//                    secondHighest = max;
//                    max = (int) c;
//                    flat++;
//                }
//            }
//            if ((int) c == max && (int) c == secondHighest) {
//                flat = 0;
//            }
//        }
//        if (max == secondHighest || flat == 0 || ((flat == 1) && (secondHighest == 48))) {
//            return -1;
//        }
//        return secondHighest - 48;
//    }