package com.jxd.model;

/**
 * @Description 职务信息
 * @Author DengRuJia
 * @Date 2020.09.12 11:42
 */
public class Job {
    private Integer jid;//职务编号
    private String jname;//职务名称
    private String deptName;//部门名称

    public Job() {
    }

    public Job(Integer jid, String jname, String deptName) {
        this.jid = jid;
        this.jname = jname;
        this.deptName = deptName;
    }

    public Job(String jname, String deptName) {
        this.jname = jname;
        this.deptName = deptName;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
