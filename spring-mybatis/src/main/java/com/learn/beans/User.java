package com.learn.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Project: spring
 * File Created at 2022-02-15 18:06:18:06
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type User.java
 * @Desc
 * @date 2022/2/15 18:06
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String address;
    private String phone;
}
