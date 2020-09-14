package com.jxd.service;

import com.jxd.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICourseService {
    /**
     * @Description 显示所有用户
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
