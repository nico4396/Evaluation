package com.jxd.controller;

import com.jxd.model.Classes;
import com.jxd.model.Student;
import com.jxd.service.IClassesService;
import com.jxd.service.IStudentListService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:39
 */
@Controller
@SessionAttributes({"student","students","clist"})
public class StudentListController {
    @Autowired
    IStudentListService iStudentListService;

    @Autowired
    IClassesService classesService;

    @RequestMapping("/getStu")
    public String getStuById(Integer sid,Model model) {
        Student student = iStudentListService.getStuById(sid);
        model.addAttribute("student",student);
        return "studentInfo";
    }
    @RequestMapping("/stuList")
    public String stuList(Model model){
        List<Classes> clist = classesService.getAllClass();
        model.addAttribute("clist",clist);
       return  "stuList";
    }

    @RequestMapping(value = "/getStuList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getStuByClass(Integer limit, Integer page, Integer classId,String sname){
        List<Map<String,Object>> list = iStudentListService.getAllStu();
        page=(page-1)*limit;
            List<Map<String,Object>> list1 = iStudentListService.getStuByClass(limit,page,classId,sname);
        JSONArray jsonArray = JSONArray.fromObject(list1);
        //创建json对象，用于返回layui表格需要的数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",list.size());//一共有多少条数据
        jsonObject.put("data",jsonArray);
        return jsonObject;
    }

    @RequestMapping("/getStuEva")
    @ResponseBody
    public List<Student> getStuEva(Integer sid){
        List<Student> list = iStudentListService.getStuEva(202001);
        return list;
    }
}
