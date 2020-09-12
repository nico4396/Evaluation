package com.jxd.model;

/**
 * @Description 工作两年评价信息
 * @Author DengRuJia
 * @Date 2020.09.12 12:24
 */
public class WorkEva_Two {
    private Integer workId;//员工编号
    private Integer jid;//职务编号
    private String appraise;//评价人
    private Integer score_Two;//评价总分
    private String content;//评价内容
    private String turnData_Two;//评价日期

    public WorkEva_Two() {
    }

    public WorkEva_Two(Integer workId, Integer jid, String appraise, Integer score_Two, String content, String turnData_Two) {
        this.workId = workId;
        this.jid = jid;
        this.appraise = appraise;
        this.score_Two = score_Two;
        this.content = content;
        this.turnData_Two = turnData_Two;
    }

    public WorkEva_Two(Integer jid, String appraise, Integer score_Two, String content, String turnData_Two) {
        this.jid = jid;
        this.appraise = appraise;
        this.score_Two = score_Two;
        this.content = content;
        this.turnData_Two = turnData_Two;
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

    public Integer getScore_Two() {
        return score_Two;
    }

    public void setScore_Two(Integer score_Two) {
        this.score_Two = score_Two;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTurnData_Two() {
        return turnData_Two;
    }

    public void setTurnData_Two(String turnData_Two) {
        this.turnData_Two = turnData_Two;
    }
}
