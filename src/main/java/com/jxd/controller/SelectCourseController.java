package com.jxd.controller;

import com.jxd.dao.ISelectCourseDao;
import com.jxd.service.ISelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 16:58
 */
@Controller
public class SelectCourseController {
    @Autowired
    ISelectCourseService selectCourseService;
    @Autowired
    ISelectCourseDao selectCourseDao;

    @RequestMapping("/selectCourse")
    public String classList(){
        return "../../WEB-INF/view/admin/selectCourse/selectCourse";
    }
    @RequestMapping("/selectCourseList")
    public String selectClassList(){
        return "../../WEB-INF/view/admin/selectCourse/selectCourseList";
    }
}
