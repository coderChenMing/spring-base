package com.learn.tx;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Project: spring
 * File Created at 2022-02-14 00:12:0:12
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type MyAspect.java
 * @Desc
 * @date 2022/2/14 0:12
 */
public class MyAspect {
    public void before() {
        System.out.println("before .....");
    }
    public void after() {
        System.out.println("after .....");
    }
    public void afterReturning() {
        System.out.println("afterReturning .....");
    }
    public void afterThrowing() {
        System.out.println("afterThrowing .....");
    }
    /*定义的around方法,参数类型和返回值类型必须如下所示*/
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before .....");
        Object obj = joinPoint.proceed();
        System.out.println("around after .....");
        return obj;
    }

}
