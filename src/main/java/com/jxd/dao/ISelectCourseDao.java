package com.jxd.dao;

import com.jxd.model.Classes;
import com.jxd.model.SelectCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ISelectCourseDao {
    /**
     * @Description  批量插入
     * @params [classid]
     * @return boolean
     **/
    //boolean addByBatchCourse(@RequestParam(value="list",required=false) List<SelectCourse> list,@Param("classid") Integer classid);
    boolean addByBatchCourse(List<SelectCourse> list);
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
    boolean deleteSCourseByid(Integer id);
}
