package com.jxd.model;

/**
 * @Description 学员信息
 * @Author DengRuJia
 * @Date 2020.09.12 11:00
 */
public class Student {
    private Integer sid;//学员编号
    private String sname;//姓名
    private String sex;//性别
    private String nation;//民族
    private String birthday;//出生年月
    private String place;//籍贯
    private String marry;//婚否
    private String tel;//电话
    private String idcard;//身份证
    private String school;//毕业学校
    private String major;//专业
    private String notes;//备注
    private Integer jid;//职务编号
    private Integer classid;//班级编号
    private String classname;//班级
    //private String jname;//职工位

    public Student() {
    }

    public Student(Integer sid, String sname, String sex, String nation, String birthday, String place, String marry, String tel, String idcard, String school, String major, String notes, Integer jid, Integer classid, String classname) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.place = place;
        this.marry = marry;
        this.tel = tel;
        this.idcard = idcard;
        this.school = school;
        this.major = major;
        this.notes = notes;
        this.jid = jid;
        this.classid = classid;
        this.classname = classname;
        //this.jname = jname;
    }

    public Student(String sname, String sex, String nation, String birthday, String place, String marry, String tel, String idcard, String school, String major, String notes, Integer jid, Integer classid, String classname) {
        this.sname = sname;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.place = place;
        this.marry = marry;
        this.tel = tel;
        this.idcard = idcard;
        this.school = school;
        this.major = major;
        this.notes = notes;
        this.jid = jid;
        this.classid = classid;
        this.classname = classname;
        //this.jname = jname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }



    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}
