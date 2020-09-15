package com.jxd.dao;

import com.jxd.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICourseDao {
    /**
     * @Description 根据couid找信息
     * @params [uid]
     * @return com.jxd.model.UserLogin
     **/
    Course getByCouid(Integer couid);
    /**
     * @Description 编辑信息
     * @params [student]
     * @return boolean
     **/
    boolean editCourse(Course course);
    /**
     * @Description 显示所有科目
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Course> getAllCourses(Integer limit, Integer page,@Param("couname") String couname);
    List<Course> getAllCourse(@Param("couname") String couname);
    /**
    * @Description  添加科目
    * @params [course]
    * @return boolean
    **/
    boolean addCourses(Course course);
    /**
     * @Description  删除学科
     * @params [id]
     * @return boolean
     **/
    boolean deleteCourseByid(Integer couid);
}
