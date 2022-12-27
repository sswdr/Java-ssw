package com.ssw.test.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ssw
 * @date 2022/9/30 10:03
 */
public class testListToJson {
    public static void main(String[] args) {
        // 先准备一个List集合
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("三笠·阿克曼", 16, false, Arrays.asList("砍巨人", "保护艾伦")));
        list.add(new Person("阿明·阿诺德", 16, true, Arrays.asList("看书", "玩海螺")));
        System.out.println(list);

        // 创建Gson实例
        Gson gson = new Gson();

        // 调用Gson的toJson方法
        String listJson = gson.toJson(list);
        System.out.println(listJson);
        // [{"name":"三笠·阿克曼","age":16,"isMale":false,"hobbies":["砍巨人","保护艾伦"]},{"name":"阿明·阿诺德","age":16,"isMale":true,"hobbies":["看书","玩海螺"]}]

        List fromJson = gson.fromJson(listJson, List.class);
        System.out.println(fromJson.get(0).getClass());// class com.google.gson.internal.LinkedTreeMap
        System.out.println(fromJson);


        // 调用Gson的 T fromJson(String, Type)将List集合的json串反序列化为List对象
        List<Person> plist = gson.fromJson(listJson, new TypeToken<List<Person>>(){}.getType());
        System.out.println(plist);
        // [Person{name='三笠·阿克曼', age=16, isMale=false, hobbies=[砍巨人, 保护艾伦]}, Person{name='阿明·阿诺德', age=16, isMale=true, hobbies=[看书, 玩海螺]}]


    }
}
