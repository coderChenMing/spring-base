package com.learn.service.impl;

import com.learn.beans.User;
import com.learn.mapper.UserMapper;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project: spring
 * File Created at 2022-02-16 10:29:10:29
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type UserServiceImpl.java
 * @Desc
 * @date 2022/2/16 10:29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }

    public List<User> listAll() {
        return userMapper.listAll();
    }
}
