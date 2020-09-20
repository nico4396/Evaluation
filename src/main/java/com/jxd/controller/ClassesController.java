package com.jxd.controller;

import com.jxd.dao.IClassesDao;
import com.jxd.model.Classes;
import com.jxd.model.Teacher;
import com.jxd.service.IClassesService;
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
 * @Date 2020.09.12 15:29
 */
@Controller
@SessionAttributes({"classes"})
public class ClassesController {
    @Autowired
    IClassesDao classesDao;
    @Autowired
    IClassesService classesService;
    /**
     * @Description 判断班级是否有科目分配
     * @params [id]
     * @return boolean
     **/
    @RequestMapping(value = "/checkClassByid",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkClassByid(Integer classid){
        boolean isCheck = classesService.checkClassByid(classid);
        if (isCheck){
            return "不能删除";
        }else {
            return "可以删除";
        }
    }
    @RequestMapping(value = "/checkName",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkName(@Param("classname") String classname){
        boolean checked = false;
        checked = classesService.checkName(classname);
        if (checked){
            return "名字已被占用";
        }else {
            return "名字可用";
        }
    }

    @RequestMapping("/getAllTeaname")
    @ResponseBody
    public List<Teacher> getAllCollegename(Model model){
        List<Teacher> list = classesService.getAllTeaname();
        model.addAttribute("list",list);
        return list;
    }
    /**
     * @Description  编辑信息
     * @params [uid, uname, pwd, power]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/editClassMethod",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editClass(Classes classes){
        boolean isEdit=classesService.editClass(classes);
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
    @RequestMapping(value = "/getByClassid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Classes getByUid(Integer classid, Model model){
        Classes classes=classesDao.getByClassid(classid);
        model.addAttribute("classes",classes);
        return classes;
    }
    /**
     * @Description 删除
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/deleteClassByid")
    @ResponseBody
    public String deleteClassByid(Integer classid) {
        boolean isdelete = classesService.deleteClassByid(classid);
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
    @RequestMapping(value = "/addClasses",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addClasses(@Param("classname") String classname,@Param("teaid") Integer teaid){
        boolean isadd = classesService.addClasses(classname, teaid);
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
    @RequestMapping(value = "/getAllClass",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllClass(Integer limit, Integer page, @Param("classname") String classname) {
        List<Classes> list = classesService.getAllClass(classname);
        page = (page-1)*limit;
        //分页查询
        List<Classes> list1 = classesService.getAllClasses(limit,page,classname);
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
    @RequestMapping("/classList")
    public String classList(){
        return "../../WEB-INF/view/admin/classes/classList";
    }
    /**
     * @Description 显示界面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/addClass")
    public String addClass(){
        return "../../WEB-INF/view/admin/classes/addClass";
    }
    @RequestMapping("/editClass")
    public String editClass(){
        return "../../WEB-INF/view/admin/classes/editClass";
    }
}
