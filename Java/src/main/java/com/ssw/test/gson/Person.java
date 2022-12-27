package com.ssw.test.gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ssw
 * @date 2022/9/30 9:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private boolean isMale;
    private List<String> hobbies;

    // 省略构造器和getter/setter方法，注意重写toString方法，便于查看控制台输出。
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", isMale=").append(isMale);
        sb.append(", hobbies=").append(hobbies);
        sb.append('}');
        return sb.toString();
    }
}
