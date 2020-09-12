package com.jxd.model;

/**
 * @Description 培训学校评价信息
 * @Author DengRuJia
 * @Date 2020.09.12 11:58
 */
public class SchoolLeva {
    private Integer schoolId;//培训学校编号
    private Integer schoolClass;//班期
    private String appraise;//评价人
    private Integer schoolScore;//评价总分
    private String content;//评价内容
    private Integer sid;//学员编号
    private String schoolDate;//评价日期

    public SchoolLeva() {
    }

    public SchoolLeva(Integer schoolClass, String appraise, Integer schoolScore, String content, Integer sid, String schoolDate) {
        this.schoolClass = schoolClass;
        this.appraise = appraise;
        this.schoolScore = schoolScore;
        this.content = content;
        this.sid = sid;
        this.schoolDate = schoolDate;
    }

    public SchoolLeva(Integer schoolId, Integer schoolClass, String appraise, Integer schoolScore, String content, Integer sid, String schoolDate) {
        this.schoolId = schoolId;
        this.schoolClass = schoolClass;
        this.appraise = appraise;
        this.schoolScore = schoolScore;
        this.content = content;
        this.sid = sid;
        this.schoolDate = schoolDate;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(Integer schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public Integer getSchoolScore() {
        return schoolScore;
    }

    public void setSchoolScore(Integer schoolScore) {
        this.schoolScore = schoolScore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSchoolDate() {
        return schoolDate;
    }

    public void setSchoolDate(String schoolDate) {
        this.schoolDate = schoolDate;
    }
}
