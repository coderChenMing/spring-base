package com.learn.proxy;

import com.learn.proxy.jdk.JDKProxy;

/**
 * Project: spring
 * File Created at 2022-02-13 22:03:22:03
 * {@link}
 * jdk动态代理测试类
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestJdkProxy.java
 * @Desc
 * @date 2022/2/13 22:03
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        Dao proxy = (Dao) new JDKProxy(new EmployeeDaoImpl()).getProxy();
        proxy.insert();
    }
}
