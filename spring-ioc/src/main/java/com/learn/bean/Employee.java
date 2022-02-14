package com.learn.bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Project: spring
 * File Created at 2022-02-13 19:45:19:45
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Employee.java
 * @Desc
 * @date 2022/2/13 19:45
 */
public class Employee {
    private int age;
    private String name;
    private double salary;
    private LocalDateTime entryTime;

    private List<String> workContent;
    private List<Work> works;
    private Map<Object, Object> record;
    private Properties note;

    public void init() {
        System.out.println("init ....");
    }

    public void destroy() {
        System.out.println("destroy ....");
    }
    public Employee() {
        System.out.println("Employee实例化");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public List<String> getWorkContent() {
        return workContent;
    }

    public void setWorkContent(List<String> workContent) {
        this.workContent = workContent;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public Map<Object, Object> getRecord() {
        return record;
    }

    public void setRecord(Map<Object, Object> record) {
        this.record = record;
    }

    public Properties getNote() {
        return note;
    }

    public void setNote(Properties note) {
        this.note = note;
    }

    /*public Employee(int age, String name, double salary, LocalDateTime entryTime, List<String> workContent, List<Work> works, Map<Object, Object> record, Properties note) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.entryTime = entryTime;
        this.workContent = workContent;
        this.works = works;
        this.record = record;
        this.note = note;
    }*/

    @Override
    public String toString() {
        return "Employee{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", salary=" + salary +
            ", entryTime=" + entryTime +
            ", workContent=" + workContent +
            ", works=" + works +
            ", record=" + record +
            ", note=" + note +
            '}';
    }
}
