package z.learn.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import z.learn.provider.Provider;

/**
 * 架构设计
 * http://dubbo.apache.org/zh-cn/docs/dev/design.html
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        context.start();
        // Obtaining a remote service proxy
        Provider demoService = (Provider) context.getBean("demoService");
        // Executing remote methods
        String hello = demoService.sayHello("world");
        // Display the call result
        System.out.println(hello);
    }
}
