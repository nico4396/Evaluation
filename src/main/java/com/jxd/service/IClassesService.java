package com.jxd.service;

import com.jxd.model.Classes;
import com.jxd.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IClassesService {

    /**
     * @return java.util.List<com.jxd.model.Classes>
     * @Description TODO 获取所有班级信息
     */
    List<Classes> getAllClassList();
    /**
     * @Description 判断班级是否有科目分配
     * @params [tid]
     * @return boolean
     **/
    boolean checkClassByid(Integer classid);
    /**
     * @Description 检查名字是否可用
     * @params [classname] 输入的姓名
     * @return boolean
     **/
    boolean checkName(@Param("classname") String classname);
    /**
     * @Description 获取老师名添加班级
     * @params []
     * @return java.util.List<com.jxd.model.College>
     **/
    List<Teacher> getAllTeaname();
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
    List<Classes> getAllClasses(Integer limit, Integer page, @Param("classname") String classname);
    List<Classes> getAllClass(@Param("classname") String classname);
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
