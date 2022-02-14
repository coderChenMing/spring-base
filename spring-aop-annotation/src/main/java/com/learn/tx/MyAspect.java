package com.learn.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * Project: spring
 * File Created at 2022-02-14 00:35:0:35
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type MyAspect.java
 * @Desc
 * @date 2022/2/14 0:35
 */
@Component
@Aspect
public class MyAspect {
    /**
     * 定义切入点,简化每次都写execution
     * 必须无参无返回
     **/
    @Pointcut("execution(* com.learn.dao.*.*(..))")
    public void pointCut() {

    }


    @Before("pointCut()")
    public void begin() {
        System.out.println("开启事务..........");
    }

    @After("pointCut()")
    public void commit() {
        System.out.println("提交事务.............");
    }
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Instant now = Instant.now();
        Object obj = proceedingJoinPoint.proceed();
        Instant now2 = Instant.now();
        System.out.println("around执行总时间: "+Duration.between(now,now2).toMillis()+"毫秒");
        return obj;
    }
}
