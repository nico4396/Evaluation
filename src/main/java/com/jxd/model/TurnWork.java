package com.jxd.model;

/**
 * @Description 转正评价信息
 * @Author DengRuJia
 * @Date 2020.09.12 12:10
 */
public class TurnWork {
    private Integer workId;//编号
    private Integer jid;//职务编号
    private String appraise;//评价人
    private Integer score;//评价总分
    private String content;//评价内容
    private String turnData;//评价日期
    private String deptName;//部门名称
    private String jname;//职务名称
    private Integer sid;//员工编号

    public TurnWork(Integer jid, String appraise, Integer score, String content, String turnData, String deptName, String jname, Integer sid) {
        this.jid = jid;
        this.appraise = appraise;
        this.score = score;
        this.content = content;
        this.turnData = turnData;
        this.deptName = deptName;
        this.jname = jname;
        this.sid = sid;
    }

    public TurnWork(String appraise, Integer score, String content, String turnData, String deptName, String jname, Integer sid) {
        this.appraise = appraise;
        this.score = score;
        this.content = content;
        this.turnData = turnData;
        this.deptName = deptName;
        this.jname = jname;
        this.sid = sid;
    }

    public TurnWork(Integer workId, Integer jid, String appraise, Integer score, String content, String turnData, String deptName, String jname, Integer sid) {
        this.workId = workId;
        this.jid = jid;
        this.appraise = appraise;
        this.score = score;
        this.content = content;
        this.turnData = turnData;
        this.deptName = deptName;
        this.jname = jname;
        this.sid = sid;
    }



    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public TurnWork(Integer workId, Integer jid, String appraise, Integer score, String content, String turnData, String deptName, String jname) {
        this.workId = workId;
        this.jid = jid;
        this.appraise = appraise;
        this.score = score;
        this.content = content;
        this.turnData = turnData;
        this.deptName = deptName;
        this.jname = jname;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public TurnWork() {
    }

    public TurnWork(Integer workId, Integer jid, String appraise, Integer score, String content, String turnData) {
        this.workId = workId;
        this.jid = jid;
        this.appraise = appraise;
        this.score = score;
        this.content = content;
        this.turnData = turnData;
    }

    public TurnWork(Integer jid, String appraise, Integer score, String content, String turnData) {
        this.jid = jid;
        this.appraise = appraise;
        this.score = score;
        this.content = content;
        this.turnData = turnData;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTurnData() {
        return turnData;
    }

    public void setTurnData(String turnData) {
        this.turnData = turnData;
    }
}
