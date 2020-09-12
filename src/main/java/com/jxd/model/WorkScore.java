package com.jxd.model;

/**
 * @Description 评价打分信息
 * @Author DengRuJia
 * @Date 2020.09.12 14:37
 */
public class WorkScore {
    private Integer id;//评价打分编号
    private Integer score;//评价打分
    private Integer evaid;//评价类型
    private Integer sid;//学院编号

    public WorkScore() {
    }

    public WorkScore(Integer id, Integer score, Integer evaid, Integer sid) {
        this.id = id;
        this.score = score;
        this.evaid = evaid;
        this.sid = sid;
    }

    public WorkScore(Integer score, Integer evaid, Integer sid) {
        this.score = score;
        this.evaid = evaid;
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getEvaid() {
        return evaid;
    }

    public void setEvaid(Integer evaid) {
        this.evaid = evaid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
