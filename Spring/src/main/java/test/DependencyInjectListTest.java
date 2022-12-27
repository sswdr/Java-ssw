package test;

import com.beans.ListTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ssw
 * @DateTime: 2021/12/9 0:20
 * @Description: TODO
 */
public class DependencyInjectListTest {

    public static void main(String[] args) {
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("helloworld.xml");
        // 获取根据参数索引依赖注入的Bean
        ListTestBean listBean =
                (ListTestBean)beanFactory.getBean("listBean");
        listBean.sayHello();
    }
}

