package com.learn.tx;

/**
 * Project: spring
 * File Created at 2022-02-13 23:02:23:02
 * {@link}
 * 定义切面类
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TransactionManager.java
 * @Desc
 * @date 2022/2/13 23:02
 */
public class TransactionManager {

    public void begin() {
        System.out.println("开启事务 ............");
    }

    public void commit() {
        System.out.println("提交事务 ...............");
    }
}
