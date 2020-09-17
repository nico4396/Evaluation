package com.jxd.service;

import com.jxd.model.Classes;
import com.jxd.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentService {
    /**
     * @Description  检查学生培训学校的评价分数
     * @params [sid]
     * @return boolean
     **/
    boolean checkMark(@Param("sid") Integer sid);
    /**
     * @Description  给学生添加职位
     * @params [jid]
     * @return boolean
     **/
    boolean addJobToStudent(@Param("jid") Integer jid,@Param("sid") Integer sid);
    /**
     * @Description 获取班级名添加学生
     * @params []
     * @return java.util.List<com.jxd.model.College>
     **/
    List<Classes> getAllClassname();
    /**
     * @Description 根据id找信息
     * @params [uid]
     * @return com.jxd.model.UserLogin
     **/
    Student getBySid(Integer sid);
    /**
     * @Description 编辑信息
     * @params [student]
     * @return boolean
     **/
    boolean editStudent(Student student);
    /**
     * @Description 显示所有
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Student> getAllStudentsAmd(Integer limit, Integer page, @Param("sname") String sname,@Param("classname") String classname);
    List<Student> getAllStudentAmd(@Param("sname") String sname,@Param("classname") String classname);
    /**
     * @Description  添加
     * @params [course]
     * @return boolean
     **/
    boolean addStudents(Student student);
    /**
     * @Description  删除
     * @params [id]
     * @return boolean
     **/
    boolean deleteStudentByid(Integer sid);
    /**
     * @Description 检查
     * @params [classname] 输入的姓名
     * @return boolean
     **/
    boolean checkClassname(@Param("classid") Integer classid);
    boolean checkStudent(@Param("sid") Integer sid);
}
