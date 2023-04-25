package com.ssw.test.cycle;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author ssw
 * @date 2023/4/17 15:50
 */
public class StackCycleTest {

    /**
     * 1	empty() 测试此堆栈是否为空
     * 2	peek()查看此堆栈顶部对象，不将其删除
     * 3	pop()删除该堆栈的顶部对象，并返回所删除的对象
     * 4	push(E item) 将一个项目推到一个栈的顶部
     * 5	search(Object o) 返回对象在堆栈中的位置，以1为基数 ,o-表示理想对象，返回值是int类型
     */
    public static int loop(int n) {
        Stack<Integer> stack = new Stack<>();
        int result = 1;
        stack.push(n);
        while (!stack.isEmpty()) {
            n = stack.pop();
            result *= n;
            if (n > 1) stack.push(n - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(loop(4));
        List<Cat> cats = Arrays.asList(new Cat("cat01"), new Cat("cat02"));
        System.out.println(cats);

        app app = new app(cats);
        System.out.println(app);
        System.out.println(app.getCats());

    }
    private static class Cat{
        private String name;

        public Cat() {
        }

        public Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

        private static class app{
        private List<Cat> cats;

            public app() {
            }

            public app(List<Cat> cats) {
                this.cats = cats;
            }

            public List<Cat> getCats() {
                return cats;
            }

            public void setCats(List<Cat> cats) {
                this.cats = cats;
            }
        }

}
