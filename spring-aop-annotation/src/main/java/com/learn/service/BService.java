package com.learn.service;

import com.learn.anno.Book;

/**
 * Project: spring
 * File Created at 2022-02-14 15:38:15:38
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type BService.java
 * @Desc
 * @date 2022/2/14 15:38
 */
public interface BService {
    void let();

    void go();

    void make(String thing);

    void anno(Book name);

    void anno2();

    void annoTest(String str,Object obj);

}
