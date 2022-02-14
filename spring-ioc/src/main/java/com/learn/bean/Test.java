package com.learn.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: spring
 * File Created at 2022-02-13 19:52:19:52
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/13 19:52
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


    }

    public static void testLazy(ApplicationContext applicationContext ) {
        // 容器默认使用单例scope=singleton
        // 容器管理对象:scope=singleton时 默认立即加载 // Employee实例化
        // scope=prototype时默认懒加载即在getBean时才加载
        Object obj = applicationContext.getBean("employee");
        Object obj2 = applicationContext.getBean("employee");
        System.out.println(obj==obj2);
    }
}
