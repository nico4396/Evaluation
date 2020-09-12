package com.jxd.model;

/**
 * @Description 工作三年评价信息
 * @Author DengRuJia
 * @Date 2020.09.12 12:25
 */
public class WorkEva_Three {
    private Integer workId;//员工编号
    private Integer jid;//职务编号
    private String appraise;//评价人
    private Integer score_Three;//评价总分
    private String content;//评价内容
    private String turnData_Three;//评价日期

    public WorkEva_Three() {
    }

    public WorkEva_Three(Integer workId, Integer jid, String appraise, Integer score_Three, String content, String turnData_Three) {
        this.workId = workId;
        this.jid = jid;
        this.appraise = appraise;
        this.score_Three = score_Three;
        this.content = content;
        this.turnData_Three = turnData_Three;
    }

    public WorkEva_Three(Integer jid, String appraise, Integer score_Three, String content, String turnData_Three) {
        this.jid = jid;
        this.appraise = appraise;
        this.score_Three = score_Three;
        this.content = content;
        this.turnData_Three = turnData_Three;
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

    public Integer getScore_Three() {
        return score_Three;
    }

    public void setScore_Three(Integer score_Three) {
        this.score_Three = score_Three;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTurnData_Three() {
        return turnData_Three;
    }

    public void setTurnData_Three(String turnData_Three) {
        this.turnData_Three = turnData_Three;
    }
}
