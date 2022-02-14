package com.learn.bean;

import org.springframework.stereotype.Component;

/**
 * Project: spring
 * File Created at 2022-02-13 21:20:21:20
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Clazz.java
 * @Desc
 * @date 2022/2/13 21:20
 */
@Component
public class Clazz {
    private String clazzName;
    private int stuNum;

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    @Override
    public String toString() {
        return "Clazz{" +
            "clazzName='" + clazzName + '\'' +
            ", stuNum=" + stuNum +
            '}';
    }
}
