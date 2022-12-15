package com.ssw.test.jdk8;

/**
 * @author ssw
 * @date 2022/7/28 18:13
 */
//public class JavaTest001 {
//    public static void main(String[] args) {
//        Fly fly = name -> System.out.println(name + "飞行");
//        fly.fly("张三");
//    }
//}
//interface Fly{
//    abstract void fly(String name);
//}


//public class JavaTest001 {
//    public static void main(String[] args) {
//        Fly fly = new Fly() {
//            @Override
//            public void fly(String name) {
//                System.out.println(name + "飞行");
//            }
//        };
//        fly.fly("张三");
//    }
//}
//
//interface Fly{
//    abstract void fly(String name);
//}

//interface MathOperation {
//    int operation(int a, int b);
//}
//
//interface GreetingService {
//    void sayMessage(String message);
//}
//
//private int operate(int a, int b, MathOperation mathOperation){
//    return mathOperation.operation(a, b);
//}
//
//interface NoParam{
//    int returnOne();
//}
//

//○ 可选类型声明：Lambda表达式可以不用声明实现方法的参数类型，编译器可以统一识别参数值。
//    // 类型声明
//    MathOperation addition = (int a, int b) -> a + b;
//    // 不用类型声明
//    MathOperation subtraction = (a, b) -> a - b;
//
//    ○ 可选的参数圆括号：一个参数无需定义圆括号，但没有参数或者多个参数需要定义圆括号。
//    // 不用括号
//    GreetingService greetService1 = message ->
//    System.out.println("Hello " + message);
//
//    // 用括号
//    GreetingService greetService2 = (message) ->
//    System.out.println("Hello " + message);
//
//    ○ 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
//    // 多条语句不可以省略大括号
//    MathOperation multiplication = (int a, int b) -> {
//    int num = a+1;
//    num = a + b;
//    return a * b + num;
//    };
//
//    // 单条语句可以省略大括号
//    MathOperation division = (int a, int b) -> a / b;
//
//    ○ 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值。
//    // 多条语句的Lambda表达式如果有返回值，需要使用return
//    MathOperation multiplication = (int a, int b) -> {
//    int num = a+1;
//    num = a + b;
//    return a * b + num;
//    };
//
//    // 单条语句可以省略return
//    MathOperation division = (int a, int b) -> a / b;


//1、为变量赋值
//上文中，对Lambda表达式的用法都是为变量赋值的写法，这样可以简化匿名内部类赋值的代码段，提高阅读效率。
//MathOperation subtraction = (a, b) -> a - b;
//
//2、作为return结果
//interface MathOperation {
//    int operation(int a, int b);
//}
//
//MathOperation getOperation(int a, int b){
//    return (a1, b1) -> a+b;
//}
//
//3、作为数组元素
//MathOperation math[] = {
//    (a,b) -> a+b,
//    (a,b) -> a-b,
//    (a,b) -> a*b
//};
//
//4、作为普通方法或者构造方法的参数
//public static void main(String args[]){
//    Java8Tester java8Tester = new Java8Tester();
//    java8Tester.operate(1,2,((a, b) -> a*b));
//}
//
//private int operate(int a, int b, MathOperation mathOperation){
//    return mathOperation.operation(a, b);
//}
//
//interface MathOperation {
//    int operation(int a, int b);
//}
