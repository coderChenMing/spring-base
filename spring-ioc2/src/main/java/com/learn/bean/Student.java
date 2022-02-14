package com.learn.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * Project: spring
 * File Created at 2022-02-13 20:54:20:54
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Studnet.java
 * @Desc
 * @date 2022/2/13 20:54
 */
@Component
//@Scope("prototype")
//@Lazy(true)
public class Student {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date enterenceTime;
    //@Autowired(required = false) //根据类型自动装配
    private Clazz clazz;

    @PostConstruct
    public void init() {
        System.out.println("init ........");
    }

    @PreDestroy
    public void destory() {
        System.out.println("destroy ...........");
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setEnterenceTime(Date enterenceTime) {
        this.enterenceTime = enterenceTime;
    }
    //@Autowired //方法上同样可以用
    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
            "stuNum='" + stuNum + '\'' +
            ", stuName='" + stuName + '\'' +
            ", stuGender='" + stuGender + '\'' +
            ", stuAge=" + stuAge +
            ", enterenceTime=" + enterenceTime +
            ", clazz=" + clazz +
            '}';
    }

    public Student() {
        System.out.println("student 无参构造执行");
    }
}
