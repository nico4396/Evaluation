package com.jxd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jxd.model.Classes;
import com.jxd.model.Student;
import com.jxd.model.TurnWork;
import com.jxd.service.IManagerEvaService;
import net.sf.json.JSONArray;
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
 * @Date 2020.09.13 10:44
 */
@Controller
@SessionAttributes({"student"})
public class ManagerEvaController {
    @Autowired
    IManagerEvaService managerEvaService;

    @RequestMapping("/empList")
    public String empList() {
        return "empList";
    }

    @RequestMapping("/turnWork")
    public String turnWork() {
        return "turnWork";
    }

    @RequestMapping(value = "/getAllStudent", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Student> getAllStudent(String sname,Integer jid) {
        List<Student> list = managerEvaService.getAllStudent(sname,jid);

        return list;
    }

/*    @RequestMapping(value = "/getStudentByPage", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Student> getStudentByPage(Integer pageSize, Integer page, String sname, HttpServletRequest request) {

        page = Integer.parseInt(request.getParameter("limit"));
        int pageIndex = Integer.parseInt(request.getParameter("page"));
        pageSize = (pageIndex - 1) * page;

        List<Student> list = managerEvaService.getStudentByPage(pageSize, page, sname);

        return list;
    }*/
    @RequestMapping(value = "/getStudentByPage", produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getStudentByPage(Integer pageSize, Integer page, String sname,Integer jid) {

        List<Student> list = managerEvaService.getAllStudent(sname,jid);

        //page = (page - 1) * pageSize;
        pageSize = (page - 1) * page;

        List<Student> list1 = managerEvaService.getStudentByPage(pageSize,page,sname,jid);
        JSONArray jsonArray = JSONArray.fromObject(list1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",list.size());
        jsonObject.put("data",jsonArray);

        return jsonObject;
    }

    @RequestMapping(value = "/getClassesName", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Classes> getClassesName() {
        List<Classes> list = managerEvaService.getClassesName();
        return list;
    }

    @RequestMapping(value = "/evaTurnWork", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String evaTurnWork(TurnWork turnWork){
        boolean isEva = managerEvaService.evaTurnWork(turnWork);
        if(isEva){
            return "评价成功";
        } else {
            return "评价失败";
        }
    }

    @RequestMapping(value = "/getById",produces = "application/json;charset=UTF-8")
    @ResponseBody//将响应内容添加至响应流
    public Student getById(Integer id, Model model){
        Student student=managerEvaService.getById(id);
        model.addAttribute("student",student);
        return student;
    }
}
