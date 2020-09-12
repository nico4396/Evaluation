package com.jxd.model;

/**
 * @Description 教师信息
 * @Author DengRuJia
 * @Date 2020.09.12 14:41
 */
public class Teacher {
    private Integer teaid;//教师编号
    private String teaname;//教师姓名
    private Integer classId;//教师所带班期

    public Teacher() {
    }

    public Teacher(Integer teaid, String teaname, Integer classId) {
        this.teaid = teaid;
        this.teaname = teaname;
        this.classId = classId;
    }

    public Teacher(String teaname, Integer classId) {
        this.teaname = teaname;
        this.classId = classId;
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
