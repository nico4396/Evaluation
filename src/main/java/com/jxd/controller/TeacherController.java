package com.jxd.controller;

import com.jxd.dao.ITeacherDao;
import com.jxd.model.Teacher;
import com.jxd.service.ITeacherService;
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
 * @Date 2020.09.12 17:00
 */
@Controller
@SessionAttributes({"teacher"})
public class TeacherController {
    @Autowired
    ITeacherDao teacherDao;
    @Autowired
    ITeacherService teacherService;
    /**
     * @Description 判断老师是否带班级
     * @params [tid]
     * @return boolean
     **/
    @RequestMapping(value = "/checkClassToTeacher",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkClassToTeacher(Integer tid){
        boolean isCheck = teacherService.checkClassToTeacher(tid);
        if (isCheck){
            return "不能删除";
        }else {
            return "可以删除";
        }
    }
    /**
     * @Description  编辑用户信息
     * @params [uid, uname, pwd, power]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/editTeacherMethod",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editTeacher(Teacher teacher){
        boolean isEdit=teacherService.editTeacher(teacher);
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
    @RequestMapping(value = "/getByTeaid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher getByTeaid(Integer teaid, Model model){
        Teacher teacher=teacherDao.getByTeaid(teaid);
        model.addAttribute("teacher",teacher);
        return teacher;
    }
    /**
     * @Description 删除
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/deleteTeacherByid")
    @ResponseBody
    public String deleteTeacherByid(Integer teaid) {
        boolean isdelete = teacherService.deleteTeacherByid(teaid);
        if (isdelete){
            return  "删除成功";
        }else {
            return "删除失败";
        }

    }
    /**
     * @Description  添加
     * @params [userLogin]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/addTeachers",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addTeachers(Teacher teacher){
        boolean isadd = teacherService.addTeachers(teacher);
        if (isadd){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
    /**
     * @Description 显示所有
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    @RequestMapping(value = "/getAllTeacher",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllCourse(Integer limit, Integer page, @Param("teaname") String teaname) {
        List<Teacher> list = teacherService.getAllTeacher(teaname);
        page = (page-1)*limit;
        //分页查询
        List<Teacher> list1 = teacherService.getAllTeachers(limit,page,teaname);
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
    @RequestMapping("/teacherList")
    public String courseList(){
        return "../../WEB-INF/view/admin/teacher/teacherList";
    }
    /**
     * @Description 显示界面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/addTeacher")
    public String addTeacher(){
        return "../../WEB-INF/view/admin/teacher/addTeacher";
    }
    @RequestMapping("/editTeacher")
    public String editTeacher(){
        return "../../WEB-INF/view/admin/teacher/editTeacher";
    }
}
