package com.jxd.model;

/**
 * @Description 课程信息
 * @Author DengRuJia
 * @Date 2020.09.12 11:53
 */
public class Course {
    private Integer couid;//课程号
    private String couname;//课程名

    public Course() {
    }

    public Course(Integer couid, String couname) {
        this.couid = couid;
        this.couname = couname;
    }

    public Course(String couname) {
        this.couname = couname;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname;
    }
}
