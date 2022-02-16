package com.learn.test;

import com.learn.beans.User;
import com.learn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Project: spring
 * File Created at 2022-02-16 11:02:11:02
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/16 11:02
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ap.getBean("userServiceImpl");
       /* User user = new User();
        user.setName("孔子");
        user.setAge(88);
        user.setAddress("山东曲阜");
        user.setPhone("13333332222");
        userService.insert(user);*/
        List<User> users = userService.listAll();
        users.forEach(System.out::println);
        // userService.insert(new User(1,"lisi",12,"北京顺义","13344443333"));

    }
}
