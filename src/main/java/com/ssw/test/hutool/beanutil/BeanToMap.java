package com.ssw.test.hutool.beanutil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ssw
 * @date 2022/9/30 10:29
 */
public class BeanToMap {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Cat {
        String catName;
        Integer catAge;
    }

    public static void main(String[] args) {
        // Cat tom = new Cat("tom", 18);
        // Map<String, Object> tomMap = BeanUtil.beanToMap(tom);
        // System.out.println(tomMap.getClass() + " / " + tomMap.toString()); // class java.util.LinkedHashMap / {name=tom, age=18}

        HashMap<String, String> catMap = new HashMap<>();
        // catMap.put("catName","jack");
        // catMap.put("catAge","6");
        catMap.put("cat_name", "jack");
        catMap.put("cat_age", "6");
        // 转Bean选项：CopyOptions
        CopyOptions copyOptions = new CopyOptions();
        Cat cat = BeanUtil.mapToBean(catMap, Cat.class, true, copyOptions);// [true] 将Map中的下划线风格key转换为驼峰风格
        System.out.println(cat);
    }
}
