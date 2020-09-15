package com.jxd.controller;

import com.jxd.dao.IStudentListDao;
import com.jxd.model.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.PrintWriter;
import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:39
 */
@Controller
@SessionAttributes({"student","students"})
public class StudentListController {
    @Autowired
    IStudentListDao iStudentListDao;

    @RequestMapping("/getStu")
    public String getStuById(Integer sid,Model model) {
        Student student = iStudentListDao.getStuById(202001);
        model.addAttribute("student",student);
        return "studentInfo";
    }
    @RequestMapping("/stuList")
    public String stuList(){
       return  "stuList";
    }

    @RequestMapping(value = "/getStuList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getStuByClass(Integer limit, Integer page, Integer classId,String sname){
        List<Student> list = iStudentListDao.getAllStuByClass(1);
        page=(page-1)*limit;
        List<Student> list1 = iStudentListDao.getStuByClass(limit,page,1,sname);
        JSONArray jsonArray = JSONArray.fromObject(list1);
        //创建json对象，用于返回layui表格需要的数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",list.size());//一共有多少条数据
        jsonObject.put("data",jsonArray);
        return jsonObject;
    }

}
