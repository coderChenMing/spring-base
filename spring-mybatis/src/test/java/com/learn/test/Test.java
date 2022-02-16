package com.learn.test;

import com.learn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: spring
 * File Created at 2022-02-16 10:58:10:58
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/16 10:58
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ap.getBean("userServiceImpl");
        userService.listAll().forEach(System.out::println);
    }
}
