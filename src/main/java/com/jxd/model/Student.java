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
    private Integer tel;//电话
    private String idCard;//身份证
    private String school;//毕业学校
    private String major;//专业
    private String notes;//备注
    private Integer jid;//职务编号
    private Integer classId;//班级编号

    public Student() {
    }

    public Student(String sname, String sex, String nation, String birthday, String place, String marry, Integer tel, String idCard, String school, String major, String notes, Integer jid, Integer classId) {
        this.sname = sname;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.place = place;
        this.marry = marry;
        this.tel = tel;
        this.idCard = idCard;
        this.school = school;
        this.major = major;
        this.notes = notes;
        this.jid = jid;
        this.classId = classId;
    }

    public Student(Integer sid, String sname, String sex, String nation, String birthday, String place, String marry, Integer tel, String idCard, String school, String major, String notes, Integer jid, Integer classId) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.place = place;
        this.marry = marry;
        this.tel = tel;
        this.idCard = idCard;
        this.school = school;
        this.major = major;
        this.notes = notes;
        this.jid = jid;
        this.classId = classId;
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

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
