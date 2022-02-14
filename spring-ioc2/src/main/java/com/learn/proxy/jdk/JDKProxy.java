package com.learn.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Project: spring
 * File Created at 2022-02-13 21:49:21:49
 * {@link InvocationHandler}拦截器接口
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type JDKProxy.java
 * @Desc
 * @date 2022/2/13 21:49
 */
public class JDKProxy implements InvocationHandler {
    private Object object;

    public JDKProxy(Object object) {
        this.object = object;
    }

    //生成动态代理
    public Object getProxy() {
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        //产生代理对象
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        begin();
        // method:对应被代理类要执行的方法名
        // args:对应被代理类执行的方法参数
        Object invoke = method.invoke(object, args);
        commit();
        return invoke;
    }

    public void begin() {
        System.out.println("开启事务。。。。。。");
    }

    public void commit() {
        System.out.println("提交事务。。。。。。");
    }
}
