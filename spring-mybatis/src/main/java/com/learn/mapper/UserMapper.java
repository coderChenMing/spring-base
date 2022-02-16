package com.learn.mapper;

import com.learn.beans.User;

import java.util.List;

/**
 * Project: spring
 * File Created at 2022-02-15 18:23:18:23
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type UserMapper.java
 * @Desc
 * @date 2022/2/15 18:23
 */
public interface UserMapper {

    Integer insert(User user);

    List<User> listAll();

    Integer updateById(User user);
}
