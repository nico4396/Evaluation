package com.jxd.model;

/**
 * @Description 工作一年评价信息
 * @Author DengRuJia
 * @Date 2020.09.12 12:21
 */
public class WorkEva_One {
    private Integer workId;//员工编号
    private Integer jid;//职务编号
    private String appraise;//评价人
    private Integer score_One;//评价总分
    private String content;//评价内容
    private String turnData_One;//评价日期

    public WorkEva_One() {
    }

    public WorkEva_One(Integer workId, Integer jid, String appraise, Integer score_One, String content, String turnData_One) {
        this.workId = workId;
        this.jid = jid;
        this.appraise = appraise;
        this.score_One = score_One;
        this.content = content;
        this.turnData_One = turnData_One;
    }

    public WorkEva_One(Integer jid, String appraise, Integer score_One, String content, String turnData_One) {
        this.jid = jid;
        this.appraise = appraise;
        this.score_One = score_One;
        this.content = content;
        this.turnData_One = turnData_One;
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

    public Integer getScore_One() {
        return score_One;
    }

    public void setScore_One(Integer score_One) {
        this.score_One = score_One;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTurnData_One() {
        return turnData_One;
    }

    public void setTurnData_One(String turnData_One) {
        this.turnData_One = turnData_One;
    }
}
