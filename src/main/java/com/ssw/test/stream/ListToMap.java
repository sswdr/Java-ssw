package com.ssw.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2022/10/12 14:55
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String id;
    private String name;
}

public class ListToMap {
    public static void main(String[] args) {
        List<User> userList = Arrays.asList(new User("1", "name_1"), new User("2", "name_2"));
        System.out.println(userList); //[User(id=1, name=name_1), User(id=2, name=name_2)]

        // 1.key和value都是对象中的某个属性值。
        Map<String, String> userMap1 = userList.stream().collect(Collectors.toMap(User::getId, User::getName));
        System.out.println(userMap1); //{1=name_1, 2=name_2}

        // 2.key是对象中的某个属性值，value是对象本身（使用返回本身的lambda表达式）。
        Map<String, User> userMap2 = userList.stream().collect(Collectors.toMap(User::getId, User -> User));
        System.out.println(userMap2); //{1=User(id=1, name=name_1), 2=User(id=2, name=name_2)}

        // 3.key是对象中的某个属性值，value是对象本身（使用Function.identity()的简洁写法）。
        Map<String, User> userMap3 = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(userMap3); //{1=User(id=1, name=name_1), 2=User(id=2, name=name_2)}

        // 4.key是对象中的某个属性值，value是对象本身，当key冲突时选择第二个key值覆盖第一个key值。
        userList.forEach(s->s.setId("1"));
        Map<String, User> userMap4 = userList.stream().collect(Collectors.toMap(User::getId, Function.identity(), (oldValue, newValue) -> newValue));
        System.out.println(userMap4); //{1=User(id=1, name=name_2)}
    }
}
