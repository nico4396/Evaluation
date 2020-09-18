package com.jxd.dao;

import com.jxd.model.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISelectCourseDao {
    /**
     * @Description 获取老师名添加班级
     * @params []
     * @return java.util.List<com.jxd.model.College>
     **/
    List<Classes> getAllclassname();
    /**
     * @Description 根据id找信息
     * @params [uid]
     * @return com.jxd.model.UserLogin
     **/
    Classes getByClassid(Integer classid);
    /**
     * @Description 编辑信息
     * @params [student]
     * @return boolean
     **/
    boolean editClass(Classes classes);
    /**
     * @Description 显示所有
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Classes> getAllSelectCourses(Integer limit, Integer page, @Param("classname") String classname,@Param("couname") String couname);
    List<Classes> getAllSelectCourse(@Param("classname") String classname,@Param("couname") String couname);
    /**
     * @Description  添加
     * @params [course]
     * @return boolean
     **/
    boolean addClasses(@Param("classname") String classname,@Param("teaid") Integer teaid);
    /**
     * @Description  删除
     * @params [id]
     * @return boolean
     **/
    boolean deleteClassByid(Integer classid);
}
