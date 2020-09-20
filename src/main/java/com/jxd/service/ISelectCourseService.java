package com.jxd.service;

import com.jxd.model.Classes;
import com.jxd.model.SelectCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 16:57
 */
public interface ISelectCourseService {
    /**
     * @Description  批量插入
     * @params [classid]
     * @return boolean
     **/
    boolean addByBatchClass(@RequestParam("list") List<SelectCourse> list, Integer classid);
    /**
     * @Description  删除
     * @params [id]
     * @return boolean
     **/
    boolean deleteSCourseByid(Integer id);
    /**
     * @Description 显示所有
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Classes> getAllSelectCourses(Integer limit, Integer page, @Param("classname") String classname,@Param("couname") String couname);
    List<Classes> getAllSelectCourse(@Param("classname") String classname,@Param("couname") String couname);
}
