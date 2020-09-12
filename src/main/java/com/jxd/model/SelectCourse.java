package com.jxd.model;

/**
 * @Description 选课信息
 * @Author DengRuJia
 * @Date 2020.09.12 14:24
 */
public class SelectCourse {
    private Integer id;//选课编号
    private String couname;//课程名称
    private Integer classId;//班级编号

    public SelectCourse() {
    }

    public SelectCourse(Integer id, String couname, Integer classId) {
        this.id = id;
        this.couname = couname;
        this.classId = classId;
    }

    public SelectCourse(String couname, Integer classId) {
        this.couname = couname;
        this.classId = classId;
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
