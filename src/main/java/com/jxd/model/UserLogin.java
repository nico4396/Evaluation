package com.jxd.model;

/**
 * @Description 用户登录信息
 * @Author DengRuJia
 * @Date 2020.09.12 11:45
 */
public class UserLogin {
    private Integer uid;//用户编号
    private String uname;//用户名
    private String pwd;//密码
    private String power;//权限

    public UserLogin() {
    }

    public UserLogin(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public UserLogin(String uname, String pwd, String power) {
        this.uname = uname;
        this.pwd = pwd;
        this.power = power;
    }

    public UserLogin(Integer uid, String uname, String pwd, String power) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.power = power;
    }

    public UserLogin(Integer uid, String uname, String power) {
        this.uid = uid;
        this.uname = uname;
        this.power = power;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
