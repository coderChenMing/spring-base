package com.learn.proxy;

/**
 * Project: spring
 * File Created at 2022-02-13 22:02:22:02
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type EmployeeDaoImpl.java
 * @Desc
 * @date 2022/2/13 22:02
 */
public class EmployeeDaoImpl implements Dao {
    public void insert() {
        System.out.println("insert employee.....");
    }

    public void update() {
        System.out.println("update employee.....");
    }

    public void delete() {
        System.out.println("delete employee.....");
    }
}
