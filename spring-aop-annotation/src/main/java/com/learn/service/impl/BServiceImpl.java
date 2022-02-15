package com.learn.service.impl;

import com.learn.anno.Book;
import com.learn.anno.MyAnno;
import com.learn.service.BService;
import org.springframework.stereotype.Service;

/**
 * Project: spring
 * File Created at 2022-02-14 15:39:15:39
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type BServiceImpl.java
 * @Desc
 * @date 2022/2/14 15:39
 */
@Service
@MyAnno("hello")
public class BServiceImpl implements BService {

    @Override
    public void let() {
        System.out.println("let ......");
    }

    @Override
    public void go() {
        System.out.println("go go go .......");

    }

    @Override
    public void make(String thing) {
        System.out.println(thing);
    }


    public void anno(Book book) {
        System.out.println("BOOK .............");
    }

    @MyAnno("anno2")
    public void anno2() {
        System.out.println("anno2 MyAnno ........");
    }

    @MyAnno("annoTest")
    public String annoTest(String str,Object obj) {
        System.out.println("annoTest MyAnno ........");
        return str;
    }
}
