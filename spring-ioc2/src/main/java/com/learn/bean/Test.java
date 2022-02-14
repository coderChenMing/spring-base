package com.learn.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: spring
 * File Created at 2022-02-13 21:02:21:02
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/13 21:02
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        testScope(applicationContext);
    }

    public static void testScope(ApplicationContext applicationContext) {
        // 通过@Scope来控制单例还是多例
        Object ob = applicationContext.getBean("student");
        Object ob2 = applicationContext.getBean("student");
        System.out.println(ob);
        System.out.println(ob2);
        System.out.println(ob==ob2);
    }

    public static void testLazy() {
        // scope=singleton时,默认立即执行构造方法
        // 可以使用@Lazy注解实现懒加载
    }
}
