package com.jxd.model;

/**
 * @Description 学分信息
 * @Author DengRuJia
 * @Date 2020.09.12 11:55
 */
public class score {
    private Integer scoid;//学分编号
    private Integer mark;//学分
    private Integer couid;//课程号
    private Integer sid;//学员编号

    public score() {
    }

    public score(Integer scoid, Integer mark, Integer couid, Integer sid) {
        this.scoid = scoid;
        this.mark = mark;
        this.couid = couid;
        this.sid = sid;
    }

    public score(Integer mark, Integer couid, Integer sid) {
        this.mark = mark;
        this.couid = couid;
        this.sid = sid;
    }

    public Integer getScoid() {
        return scoid;
    }

    public void setScoid(Integer scoid) {
        this.scoid = scoid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
