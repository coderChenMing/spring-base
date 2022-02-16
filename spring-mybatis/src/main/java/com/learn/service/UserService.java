package com.learn.service;

import com.learn.beans.User;

import java.util.List;

/**
 * Project: spring
 * File Created at 2022-02-16 10:29:10:29
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type UserService.java
 * @Desc
 * @date 2022/2/16 10:29
 */
public interface UserService {

    Integer insert(User user);

    Integer updateById(User user);

    List<User> listAll();
}
