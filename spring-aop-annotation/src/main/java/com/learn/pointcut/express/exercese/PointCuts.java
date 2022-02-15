package com.learn.pointcut.express.exercese;

import com.learn.anno.MyAnno;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(PointCuts.class);

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
    // @Before("@annotation(myAnno)")
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
        proceedingJoinPointUse(proceedingJoinPoint);
        Object obj = proceedingJoinPoint.proceed();
        logEnd();
        return obj;
    }

    public void proceedingJoinPointUse(ProceedingJoinPoint pjp) {
        // 查看ProceedingJoinPoint extends JoinPoint
        // 获取切入点所在目标对象
        /*Object target = pjp.getTarget();
        String name = target.getClass().getName();*/

        /*pjp:
        getTarget:被代理类信息,可以获取被代理类的方法,字段,注解等等信息
        getSignature:获取切入点方法信息,包括方法所在类名等基础信息*/

        LOGGER.info("被代理类全限定名:{}", pjp.getTarget().getClass().getName());// com.learn.service.impl.BServiceImpl
        System.out.println("-----------------------------------------------------------------------------------------");
        Class type = pjp.getSignature().getDeclaringType();
        LOGGER.info("方法所在接口类型type:{}", type);
        String declaringTypeName = pjp.getSignature().getDeclaringTypeName();
        LOGGER.info("方法所在接口类型 declaringTypeName:{}", declaringTypeName);
        int modifiers = pjp.getSignature().getModifiers();
        LOGGER.info("modifiers {}", modifiers);
        Class<? extends Signature> aClass = pjp.getSignature().getClass();
        LOGGER.info("aClass:{}", aClass);
        LOGGER.info("获取切入点方法的名字:{}", pjp.getSignature().getName());
        System.out.println("-----------------------------------------------------------------------------------------");
        // 获取方法上的注解
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            MyAnno annotation = method.getAnnotation(MyAnno.class);
            LOGGER.info("{}方法上注解信息{}", pjp.getSignature().getName(), annotation);
            // annotation打印结果为空,因为这里获取的使接口方法,而接口方法是没有添加注解的,注解在实现类方法之上
        }
        System.out.println("----------------------------------------------------------------------------------------");
        Method method2 = null;
        Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        try {
            // 方法名,方法参数
            method2 = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (method2 != null) {
            LOGGER.info("实现类{}上注解是{}", pjp.getTarget().getClass().getName(), Arrays.asList(method2.getAnnotations()));
            //System.out.println(Arrays.asList(method2.getAnnotations()));
        }
        System.out.println("----------------------------------------------------------------------------------------");
        for (Method method1 : pjp.getTarget().getClass().getMethods()) {
            if (method1.getName().equals(pjp.getSignature().getName())) {
                Annotation annotation = method1.getAnnotation(MyAnno.class);
                LOGGER.info("{}方法上注解信息{}", pjp.getSignature().getName(), annotation);
            }
        }
        Object[] args = pjp.getArgs();
        // 打印被代理方法上参数列表
        Arrays.stream(args).forEach(System.out::println);
    }

    public void logStart() {
        System.out.println("log start .........");
    }

    public void logEnd() {
        System.out.println("log end .........");
    }

    public void testLombok() {
        val sets = new HashSet<String>();
    }
}
