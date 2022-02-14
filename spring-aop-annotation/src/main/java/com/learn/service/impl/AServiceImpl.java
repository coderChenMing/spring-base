package com.learn.service.impl;

import com.learn.service.AService;
import org.springframework.stereotype.Service;

/**
 * Project: spring
 * File Created at 2022-02-14 15:22:15:22
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type AServiceImpl.java
 * @Desc
 * @date 2022/2/14 15:22
 */
@Service
public class AServiceImpl implements AService {
    @Override
    public void check() {
        System.out.println("check ..........");
    }

    @Override
    public void show() {
        System.out.println("show ..............");

    }
}
