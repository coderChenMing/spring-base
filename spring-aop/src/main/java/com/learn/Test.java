package com.learn;

import com.learn.dao.BookDaoImpl;
import com.learn.dao.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: spring
 * File Created at 2022-02-13 23:11:23:11
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/13 23:11
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //testBookDaoImpl(applicationContext);
        testStudentDaoImpl(applicationContext);
    }

    public static void testBookDaoImpl(ApplicationContext applicationContext) {
        BookDaoImpl bookDao = (BookDaoImpl) applicationContext.getBean("bookDao");
        bookDao.update();
        bookDao.delete();
        bookDao.insert();

    }
    public static void testStudentDaoImpl(ApplicationContext applicationContext) {
        StudentDaoImpl studentDao = (StudentDaoImpl) applicationContext.getBean("studentDao");

        studentDao.insert();

    }
}
