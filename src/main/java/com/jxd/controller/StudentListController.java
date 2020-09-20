package com.jxd.controller;

import com.jxd.dao.ISelectCourseDao;
import com.jxd.model.Classes;
import com.jxd.service.ISelectCourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:39
 */
@Controller
public class StudentListController {
    @Autowired
    ISelectCourseDao selectCourseDao;
    @Autowired
    ISelectCourseService selectCourseService;
    /**
     * @Description 显示所有
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    @RequestMapping(value = "/getAllSelectCourse",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllSelectCourse(Integer limit, Integer page, @Param("classname") String classname, @Param("couname") String couname) {
        List<Classes> list = selectCourseService.getAllSelectCourse(classname,couname);
        page = (page-1)*limit;
        //分页查询
        List<Classes> list1 = selectCourseService.getAllSelectCourses(limit,page,classname,couname);
        //将list转换为json数组
        JSONArray jsonArray = JSONArray.fromObject(list1);
        //创建json对象，用于返回layui表格需要的数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg", "");
        jsonObject.put("count", list.size());
        jsonObject.put("data", jsonArray);
        return jsonObject ;
    }

}
