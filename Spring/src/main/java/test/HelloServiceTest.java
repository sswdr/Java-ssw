package test;

import com.services.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 22:49
 * @Description: TODO
 */
public class HelloServiceTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("helloworld.xml");
        // 从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        HelloService helloService =
                context.getBean("helloService", HelloService.class);
        // 执行业务逻辑
        helloService.sayHello();
    }
}

