package com.jxd.controller;

import com.jxd.dao.IStudentDao;
import com.jxd.model.Classes;
import com.jxd.model.Student;
import com.jxd.service.IStudentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 17:05
 */
@Controller
@SessionAttributes({"student"})
public class StudentController {
    @Autowired
    IStudentDao studentDao;
    @Autowired
    IStudentService studentService;
    @RequestMapping(value = "/CheckMark",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String CheckMark(@Param("sid") Integer sid){
        boolean isCheck = studentDao.checkMark(sid);
        if (isCheck){
            return "可以入职";
        }else {
            return "不可以入职";
        }
    }
    @RequestMapping(value = "/addJobToStudent",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addJobToStudent(Integer jid,@Param("sid") Integer sid) {
        boolean isadd = studentDao.addJobToStudent(jid,sid);
        if (isadd){
            return  "添加成功";
        }else {
            return "添加失败";
        }
    }
    @RequestMapping(value = "/checkClassname",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkName(@Param("sid") Integer sid){
        boolean checked = false;
        checked = studentDao.checkStudent(sid);
        if (checked){
            return "该学生已毕业不能修改";
        }else {
            return "可以修改班级";
        }
    }

    @RequestMapping("/getAllClassname")
    @ResponseBody
    public List<Classes> getAllClassname(Model model){
        List<Classes> list = studentDao.getAllClassname();
        model.addAttribute("list",list);
        return list;
    }
    /**
     * @Description  编辑信息
     * @params [uid, uname, pwd, power]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/editStudentMethod",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editStudent(Student student){
        boolean isEdit=studentDao.editStudent(student);
        if (isEdit) {
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
    /**
     * @Description  根据id获取信息
     * @params [uid, model]
     * @return com.jxd.model.UserLogin
     **/
    @RequestMapping(value = "/getBySid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Student getBySid(Integer sid, Model model){
        Student student=studentDao.getBySid(sid);
        model.addAttribute("student",student);
        return student;
    }
    /**
     * @Description 判断
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/checkStudent")
    @ResponseBody
    public String checkStudent(Integer sid) {
        boolean isHave = studentDao.checkStudent(sid);
        if (isHave){
            return  "该学生已毕业不能删除";
        }else {
            return "可以删除";
        }
    }
    /**
     * @Description 删除
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/deleteStudentByid")
    @ResponseBody
    public String deleteStudentByid(Integer sid) {
        boolean isdelete = studentDao.deleteStudentByid(sid);
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
    @RequestMapping(value = "/addStudents",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addStudents(Student student){
        boolean isadd = studentDao.addStudents(student);
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
    @RequestMapping(value = "/getAllStudentAmd",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllStudentAmd(Integer limit, Integer page, @Param("sname") String sname,@Param("classname") String classname) {
        List<Student> list = studentDao.getAllStudentAmd(sname,classname);
        page = (page-1)*limit;
        //分页查询
        List<Student> list1 = studentDao.getAllStudentsAmd(limit,page,sname,classname);
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
    @RequestMapping("/addStudent")
    public String addStudents(){
        return "../../WEB-INF/view/admin/student/addStudent";
    }
    @RequestMapping("/addJobForStu")
    public String addJob(){
        return "../../WEB-INF/view/admin/student/addJobForStu";
    }
    @RequestMapping("/editStudent")
    public String editClass(){
        return "../../WEB-INF/view/admin/student/editStudent";
    }
    @RequestMapping("/studentList")
    public String studentList(){
        return "../../WEB-INF/view/admin/student/studentList";
    }
}
