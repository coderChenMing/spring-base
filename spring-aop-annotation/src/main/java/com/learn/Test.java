package com.learn;

import com.learn.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: spring
 * File Created at 2022-02-14 00:30:0:30
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/14 0:30
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        getUserDao(applicationContext);
    }

    public static void getUserDao(ApplicationContext applicationContext) {
        UserDaoImpl userDao = (UserDaoImpl) applicationContext.getBean("userDaoImpl");
        userDao.insert();
    }
}
