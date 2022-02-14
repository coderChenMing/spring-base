package com.learn.bean;

/**
 * Project: spring
 * File Created at 2022-02-13 19:47:19:47
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Work.java
 * @Desc
 * @date 2022/2/13 19:47
 */
public class Work {
    private String content;
    private int count;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Work{" +
            "content='" + content + '\'' +
            ", count=" + count +
            '}';
    }

}
