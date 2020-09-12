package com.jxd.model;

/**
 * @Description 评价类型信息
 * @Author DengRuJia
 * @Date 2020.09.12 14:17
 */
public class Evaluate {
    private Integer evaid;//评价类型编号
    private String evaname;//评价类型名称

    public Evaluate() {
    }

    public Evaluate(Integer evaid, String evaname) {
        this.evaid = evaid;
        this.evaname = evaname;
    }

    public Evaluate(String evaname) {
        this.evaname = evaname;
    }

    public Integer getEvaid() {
        return evaid;
    }

    public void setEvaid(Integer evaid) {
        this.evaid = evaid;
    }

    public String getEvaname() {
        return evaname;
    }

    public void setEvaname(String evaname) {
        this.evaname = evaname;
    }
}
