package com.ssw.test.jdk8;

import java.util.function.Supplier;

/**
 * @author ssw
 * @date 2022/7/28 18:01
 */
//public class Java8Tester {
//
//    public static void main(String[] args) {
//
//        // 静态方法引用--通过类名调用
//        GreetingService greetingService = Test::MyNameStatic;
//        greetingService.sayMessage("hello");
//        Test t = new Test();
//        //实例方法引用--通过实例调用
//        GreetingService greetingService2 = t::myName;
//        // 构造方法方法引用--无参数
//        Supplier<Test> supplier = Test::new;
//        System.out.println(supplier.get());
//    }
//
//    interface GreetingService {
//        void sayMessage(String message);
//    }
//}
//
//class Test {
//    // 静态方法
//    public static void MyNameStatic(String name) {
//        System.out.println(name);
//    }
//
//    // 实例方法
//    public void myName(String name) {
//        System.out.println(name);
//    }
//
//    // 无参构造方法
//    public Test() {
//    }
//}

public class Java8Tester {
    public static void main(String[] args){
        // 静态方法引用--通过类名调用
        GreetingService greetingService = Test::MyNameStatic;
        greetingService.sayMessage("MyNameStatic");
        Test t = new Test();
        //实例方法引用--通过实例调用
        GreetingService greetingService2 = t::myName;
        greetingService2.sayMessage("myName");
        // 构造方法方法引用--无参数
        Supplier<Test> supplier = Test::new;
        System.out.println(supplier.get());
        System.out.println(supplier);
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}

class Test {
    // 静态方法
    public static void MyNameStatic(String name) {
        System.out.println(name);
    }
    // 实例方法
    public void myName(String name) {
        System.out.println(name);
    }
    // 无参构造方法
    public Test() {
    }
}