package com.jxd.controller;

import com.jxd.dao.IStudentListDao;
import com.jxd.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:39
 */
@Controller
@SessionAttributes({"student"})
public class StudentListController {
    @Autowired
    IStudentListDao iStudentListDao;

    @RequestMapping(value = "/getStu", produces = "text/html;charset=utf-8")
    @ResponseBody
    public Student getStuById(Integer sid,Model model) {
        Student student = iStudentListDao.getStuById(1);
        model.addAttribute("student",student);
        return student;
    }
}
