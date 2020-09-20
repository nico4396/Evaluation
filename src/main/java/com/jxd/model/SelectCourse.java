package com.jxd.model;

/**
 * @Description 选课信息
 * @Author DengRuJia
 * @Date 2020.09.12 14:24
 */
public class SelectCourse {
    private Integer id;//选课编号
    private String couname;//课程名称
    private Integer classid;//班级编号
    private String classname;//班级名称

    public SelectCourse() {
    }

    public SelectCourse(String couname, Integer classid) {
        this.couname = couname;
        this.classid = classid;
    }

    public SelectCourse(String couname, Integer classid, String classname) {
        this.couname = couname;
        this.classid = classid;
        this.classname = classname;
    }

    public SelectCourse(Integer id, String couname, Integer classid, String classname) {
        this.id = id;
        this.couname = couname;
        this.classid = classid;
        this.classname = classname;
    }

    public SelectCourse(Integer id, Integer classid) {
        this.id = id;
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}
