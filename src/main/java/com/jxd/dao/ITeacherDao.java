package com.jxd.dao;

import com.jxd.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITeacherDao {
    /**
     * @Description 根据用户id找信息
     * @params [uid]
     * @return com.jxd.model.UserLogin
     **/
    Teacher getByTeaid(Integer teaid);
    /**
     * @Description 判断老师是否带班级
     * @params [tid]
     * @return boolean
     **/
    boolean checkClassToTeacher(Integer tid);
    /**
     * @Description 编辑信息
     * @params [student]
     * @return boolean
     **/
    boolean editTeacher(Teacher teacher);
    /**
     * @Description 显示所有用户
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Teacher> getAllTeachers(Integer limit, Integer page, @Param("teaname") String teaname);
    List<Teacher> getAllTeacher(@Param("teaname") String teaname);
    /**
     * @Description  添加
     * @params [course]
     * @return boolean
     **/
    boolean addTeachers(Teacher teacher);
    /**
     * @Description  删除
     * @params [id]
     * @return boolean
     **/
    boolean deleteTeacherByid(Integer teaid);
}
