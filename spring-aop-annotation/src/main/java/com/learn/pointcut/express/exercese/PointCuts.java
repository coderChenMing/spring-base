package com.learn.pointcut.express.exercese;

import com.learn.anno.MyAnno;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Project: spring
 * File Created at 2022-02-14 15:25:15:25
 * {@link}
 * 当我们的切面很多的时候，我们可以把所有的切面放到单独的一个类去，进行统一管理
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type PointCuts.java
 * @Desc
 * @date 2022/2/14 15:25
 */
@Component
@Aspect
public class PointCuts {
    @Pointcut("execution(public * *.insert(..))")
    public void pointCut() {

    }

    @Pointcut("within(com.learn.service.impl.AServiceImpl)")
    public void pointCut1() {

    }

    // 匹配包以及子包内的所有类:
    @Pointcut("within(com.learn.service..*)")
    public void pointCut2() {

    }

    // this就表示代理对象。拦截AService所有的子类的所有外部调用方法
    @Pointcut("this(com.learn.service.AService)")
    public void pointCut3() {

    }

    // Spring Aop是基于代理的，target则表示被代理的目标对象。
    // 当被代理的目标对象可以被转换为指定的类型时则表示匹配。 注意：和上面不一样，这里是target，因此如果要切入，只能写实现类了
    @Pointcut("target(com.learn.service.impl.AServiceImpl)")
    public void pointCut4() {

    }

    //@Pointcut("args()")
    @Pointcut("args(java.lang.String)")
    public void pointCut5() {

    }

    @Pointcut("@target(com.learn.anno.MyAnno)")
    public void pointCut6() {

    }

    // @args匹配被调用的方法上含有参数，且对应的参数类型上拥有指定的注解的情况
    // 如BServiceImpl.anno(Book book ) Book类使用@MyAnno修饰
    @Pointcut("@args(com.learn.anno.MyAnno)")
    public void pointCut7() {

    }

    // 可以匹配所有方法上标有@MyAnno注解的方法
    @Pointcut("@annotation(com.learn.anno.MyAnno)")
    public void pointCut8() {

    }
    // bean用于匹配当调用的是指定的Spring的某个bean的方法时
    @Pointcut("bean(BServiceImpl)")
    public void pointCut9() {

    }
    // 对beanName/id=BServiceImpl且无参的方法进行增强
    @Pointcut("bean(BServiceImpl)&&args()")
    public void pointCut10() {

    }

    // 对beanName/id=BServiceImpl且有参的方法进行增强
    @Pointcut("bean(BServiceImpl)&&!args()")
    public void pointCut11() {

    }

    // 对beanName/id=BServiceImpl且注解为MyAnno的方法进行增强
    @Pointcut("bean(BServiceImpl)&&@annotation(com.learn.anno.MyAnno)")
    public void pointCut12() {

    }


    // 快速获取注解的方式
    @Before("@annotation(myAnno)")
    public void doBefore(JoinPoint joinPoint, MyAnno myAnno) {
        System.out.println(myAnno);
        System.out.println("AOP before advice");
    }

    @Before("pointCut()")
    public void begin() {
        System.out.println("开启事务 .........");
    }

    @After("pointCut()")
    public void commit() {
        System.out.println("提交事务 .........");
    }

    // @target匹配当被代理的目标对象对应的类型及其父类型上拥有指定的注解时。
    @Around("pointCut12()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logStart();
        Object obj = proceedingJoinPoint.proceed();
        logEnd();
        return obj;
    }

    public void logStart() {
        System.out.println("log start .........");
    }

    public void logEnd() {
        System.out.println("log end .........");
    }
}
