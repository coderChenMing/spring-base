package com.learn.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Project: spring
 * File Created at 2022-02-13 22:13:22:13
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type CglibProxy.java
 * @Desc
 * @date 2022/2/13 22:13
 */
public class CglibProxy implements MethodInterceptor {
    private Object object;

    public CglibProxy(Object object) {
        this.object = object;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        // 指定父类
        enhancer.setSuperclass(object.getClass());
        // 指定callback参数
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        begin();
        // method:对应被代理类要执行的方法名
        // args:对应被代理类执行的方法参数
        Object returnValue = method.invoke(object,args);
        commit();
        return returnValue;
    }

    public void begin() {
        System.out.println("开启事务。。。。。。");
    }

    public void commit() {
        System.out.println("提交事务。。。。。。");
    }
}
