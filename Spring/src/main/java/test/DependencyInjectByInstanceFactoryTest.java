package test;

import com.services.HelloService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ssw
 * @DateTime: 2021/12/8 23:18
 * @Description: TODO
 */
public class DependencyInjectByInstanceFactoryTest {

    public static void main(String[] args) {
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("helloworld.xml");
        // 获取根据参数索引依赖注入的Bean
        HelloService byIndex =
                beanFactory.getBean("ifByIndex",HelloService.class);
        byIndex.sayHello();
        // 获取根据参数类型依赖注入的Bean
        HelloService byType =
                beanFactory.getBean("ifByType", HelloService.class);
        byType.sayHello();
        // 获取根据参数名字依赖注入的Bean
        HelloService byName =
                beanFactory.getBean("ifByName", HelloService.class);
        byName.sayHello();
    }
}


