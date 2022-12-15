package com.ssw.test.hutool.objectutil;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author ssw
 * @date 2022/10/12 14:25
 */
public class ObjectUtilTest {
    public static void main(String[] args) {
        Object ob = new Object();
        System.out.println(ObjectUtil.isEmpty(ob));
    }
}
