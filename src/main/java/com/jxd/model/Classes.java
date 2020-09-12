package com.jxd.model;

/**
 * @Description 班级信息
 * @Author DengRuJia
 * @Date 2020.09.12 14:22
 */
public class Classes {
    private Integer classId;//班级编号
    private String className;//班级名称

    public Classes() {
    }

    public Classes(String className) {
        this.className = className;
    }

    public Classes(Integer classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
