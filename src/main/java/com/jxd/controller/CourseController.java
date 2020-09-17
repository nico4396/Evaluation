package com.jxd.controller;


import com.jxd.dao.ICourseDao;
import com.jxd.model.Course;
import com.jxd.service.ICourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 15:10
 */
@Controller
@SessionAttributes({"course"})
public class CourseController {
    @Autowired
    ICourseDao courseDao;
    @Autowired
    ICourseService courseService;
    /**
     * @Description  编辑用户信息
     * @params [uid, uname, pwd, power]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/editCourseMethod",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editCourse(Course course){
        boolean isEdit=courseService.editCourse(course);
        if (isEdit) {
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
    /**
     * @Description  根据uid获取用户信息
     * @params [uid, model]
     * @return com.jxd.model.UserLogin
     **/
    @RequestMapping(value = "/getByCouid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Course getByUid(Integer couid, Model model){
        Course course=courseDao.getByCouid(couid);
        model.addAttribute("course",course);
        return course;
    }
    /**
     * @Description 删除科目
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/deleteCourseByid")
    @ResponseBody
    public String deleteCourseByid(Integer couid) {
        boolean isdelete = courseService.deleteCourseByid(couid);
        if (isdelete){
            return  "删除成功";
        }else {
            return "删除失败";
        }

    }
    /**
     * @Description  添加课程
     * @params [userLogin]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/addCourses",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addCourses(Course course){
        boolean isadd = courseService.addCourses(course);
        if (isadd){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
    /**
     * @Description 显示所有课程
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    @RequestMapping(value = "/getAllCourse",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllCourse(Integer limit, Integer page, @Param("couname") String couname) {
        List<Course> list = courseService.getAllCourse(couname);
        page = (page-1)*limit;
        //分页查询
        List<Course> list1 = courseService.getAllCourses(limit,page,couname);
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

    /**
    * @Description 显示界面
    * @params []
    * @return java.lang.String
    **/
    @RequestMapping("/courseList")
    public String courseList(){
        return "../../WEB-INF/view/admin/course/courseList";
    }
    /**
     * @Description 显示界面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/addCourse")
    public String addCourse(){
        return "../../WEB-INF/view/admin/course/addCourse";
    }
    @RequestMapping("/editCourse")
    public String editCourse(){
        return "../../WEB-INF/view/admin/course/editCourse";
    }
}
