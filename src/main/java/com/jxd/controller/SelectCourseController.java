package com.jxd.controller;

import com.jxd.dao.ISelectCourseDao;
import com.jxd.model.SelectCourse;
import com.jxd.service.ISelectCourseService;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
//@RequestParam(value="list",required=false) List<SelectCourse> list,
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
    @RequestMapping(value = "/addByBatchClass",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addByBatchClass(String lists, @Param("classid") Integer classid) {
        //JSONArray counames = JSONArray.fromObject(lists);
        String[] split = lists.split(",");
        List<SelectCourse> list1 = new ArrayList<>();
        for (int i = 0;i<split.length;i++){
            SelectCourse selectCourse = new SelectCourse(split[i],classid);
            list1.add(selectCourse);
        }
        boolean isadd = selectCourseDao.addByBatchCourse(list1);
        if (isadd){
            return "选课成功";
        }else {
            return "选课失败";
        }
    }
    /**
     * @Description 删除用户
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/deleteSCourseByid")
    @ResponseBody
    public String deleteSCourseByid(Integer id) {
        boolean isdelete = selectCourseService.deleteSCourseByid(id);
        if (isdelete){
            return  "删除成功";
        }else {
            return "删除失败";
        }

    }
    @RequestMapping("/addSelectCourse")
    public String addclassList(){
        return "../../WEB-INF/view/admin/selectCourse/addSelectCourse";
    }
    @RequestMapping("/selectCourse")
    public String classList(){
        return "../../WEB-INF/view/admin/selectCourse/selectCourse";
    }
    @RequestMapping("/selectCourseList")
    public String selectClassList(){
        return "../../WEB-INF/view/admin/selectCourse/selectCourseList";
    }
}
