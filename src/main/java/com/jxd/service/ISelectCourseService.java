package com.jxd.service;

import com.jxd.model.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 16:57
 */
public interface ISelectCourseService {
    /**
     * @Description 显示所有
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Classes> getAllSelectCourses(Integer limit, Integer page, @Param("classname") String classname,@Param("couname") String couname);
    List<Classes> getAllSelectCourse(@Param("classname") String classname,@Param("couname") String couname);
}
