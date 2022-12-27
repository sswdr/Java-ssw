package com.ssw.test.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ssw
 * @date 2022/9/30 10:14
 */
public class testMapToJson {
    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<>();
        map.put("p1", new Person("利威尔·阿克曼", 35, true, Arrays.asList("砍猴儿", "打扫卫生")));
        map.put("p2", new Person("韩吉·佐耶", 33, false, Arrays.asList("研究巨人", "讲故事")));

        // 创建Gson实例
        Gson gson = new Gson();

        //Map集合 -> Json字符串
        String mapJson = gson.toJson(map);
        System.out.println(mapJson);
        // {"p1":{"name":"利威尔·阿克曼","age":35,"isMale":true,"hobbies":["砍猴儿","打扫卫生"]},"p2":{"name":"韩吉·佐耶","age":33,"isMale":false,"hobbies":["研究巨人","讲故事"]}}

        Map<String, Person> jsonMap = gson.fromJson(mapJson, new TypeToken<Map<String, Person>>() { }.getType());
        System.out.println(jsonMap);
        //{p1=Person{name='利威尔·阿克曼', age=35, isMale=true, hobbies=[砍猴儿, 打扫卫生]}, p2=Person{name='韩吉·佐耶', age=33, isMale=false, hobbies=[研究巨人, 讲故事]}}
    }
}
