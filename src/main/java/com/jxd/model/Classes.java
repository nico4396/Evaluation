package com.jxd.model;

/**
 * @Description 班级信息
 * @Author DengRuJia
 * @Date 2020.09.12 14:22
 */
public class Classes {
    private Integer classid;//班级编号
    private String classname;//班级名称
    private Integer teaid;//教师编号
    private String teaname;//教师姓名

    public Classes() {
    }

    public Classes(Integer classid, String classname, Integer teaid, String teaname) {
        this.classid = classid;
        this.classname = classname;
        this.teaid = teaid;
        this.teaname = teaname;
    }

    public Classes(String classname, Integer teaid, String teaname) {
        this.classname = classname;
        this.teaid = teaid;
        this.teaname = teaname;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }
}
