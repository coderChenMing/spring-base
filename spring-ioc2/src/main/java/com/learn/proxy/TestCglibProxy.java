package com.learn.proxy;

import com.learn.proxy.cglib.CglibProxy;

/**
 * Project: spring
 * File Created at 2022-02-13 22:19:22:19
 * {@link net.sf.cglib.proxy.Enhancer}
 * cglib代理测试类
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestCglibProxy.java
 * @Desc
 * @date 2022/2/13 22:19
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = (EmployeeDaoImpl) new CglibProxy(new EmployeeDaoImpl()).getProxy();
        employeeDao.delete();
    }
}
