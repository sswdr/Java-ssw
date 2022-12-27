package com.ssw.test.gson;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * @author ssw
 * @date 2022/9/30 9:44
 */
public class testBeanToJson {
    public static void main(String[] args) {
        // 创建Bean
        Person p = new Person("艾伦·耶格尔", 16, true, Arrays.asList("自由", "迫害莱纳"));
        System.out.println(p);  // Person{name='艾伦·耶格尔', age=16, isMale=true, hobbies=[自由, 迫害莱纳]}

        // 创建Gson对象
        Gson gson = new Gson();

        // 调用Gson的String toJson(Object)方法将Bean转换为json字符串
        String pJson = gson.toJson(p);

        System.out.println(pJson);
        // {"name":"艾伦·耶格尔","age":16,"isMale":true,"hobbies":["自由","迫害莱纳"]}

        Person person = gson.fromJson(pJson, Person.class);
        System.out.println(person);
        // Person{name='艾伦·耶格尔', age=16, isMale=true, hobbies=[自由, 迫害莱纳]}

    }
}
