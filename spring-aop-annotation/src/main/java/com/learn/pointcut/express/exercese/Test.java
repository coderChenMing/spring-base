package com.learn.pointcut.express.exercese;

import com.learn.anno.Book;
import com.learn.service.AService;
import com.learn.service.BService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: spring
 * File Created at 2022-02-14 15:08:15:08
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/14 15:08
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
         // testWithIn(ap);
         testWithIn2(ap);
    }
    public static void testWithIn(ApplicationContext ap) {
        AService aService = (AService) ap.getBean("AServiceImpl");
        aService.check();
    }
    public static void testWithIn2(ApplicationContext ap) {
        BService bService = (BService) ap.getBean("BServiceImpl");
        // bService.let();
        // bService.go();
        // bService.make("我爱北京天安门 ..........");
        // bService.anno(new Book());
         bService.anno2();
         bService.annoTest("张三",new Book());
    }


}
