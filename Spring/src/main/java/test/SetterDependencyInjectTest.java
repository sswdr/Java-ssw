package test;

import com.services.HelloService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ssw
 * @DateTime: 2021/12/9 0:19
 * @Description: TODO
 */
public class SetterDependencyInjectTest {
    public static void main(String[] args) {
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("helloworld.xml");
        HelloService bean =
                beanFactory.getBean("bean", HelloService.class);
        bean.sayHello();
    }
}
