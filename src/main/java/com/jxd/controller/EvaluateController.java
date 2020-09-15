package com.jxd.controller;

import com.jxd.dao.ICourseDao;
import com.jxd.dao.IEvaluateDao;
import com.jxd.model.Course;
import com.jxd.model.Evaluate;
import com.jxd.service.ICourseService;
import com.jxd.service.IEvaluateService;
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
 * @Date 2020.09.12 15:27
 */
@Controller
@SessionAttributes("evaluate")
public class EvaluateController {
    @Autowired
    IEvaluateDao evaluateDao;
    @Autowired
    IEvaluateService evaluateService;
    /**
     * @Description  编辑用户信息
     * @params [uid, uname, pwd, power]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/editWorkTypeMethod",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editWorkType(Evaluate evaluate){
        boolean isEdit=evaluateService.editWorkType(evaluate);
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
    @RequestMapping(value = "/getByEvaid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Evaluate getByEvaid(Integer evaid, Model model){
        Evaluate evaluate=evaluateDao.getByEvaid(evaid);
        model.addAttribute("evaluate",evaluate);
        return evaluate;
    }
    /**
     * @Description 删除用户
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/deleteWorkTypeByid")
    @ResponseBody
    public String deleteWorkTypeByid(Integer evaid) {
        boolean isdelete = evaluateService.deleteWorkTypeByid(evaid);
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
    @RequestMapping(value = "/addWorkTypes",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addWorkTypes(Evaluate evaluate){
        boolean isadd = evaluateService.addWorkTypes(evaluate);
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
    @RequestMapping(value = "/getAllEvaluate",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllEvalute(Integer limit, Integer page, @Param("evaname") String evaname) {
        List<Evaluate> list = evaluateService.getAllEvaluate(evaname);
        page = (page-1)*limit;
        //分页查询
        List<Evaluate> list1 = evaluateService.getAllEvaluates(limit,page,evaname);
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
    @RequestMapping("/workTypeList")
    public String workTypeList(){
        return "workTypeList";
    }
    /**
     * @Description 显示界面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/addWorkType")
    public String addWorkType(){
        return "addWorkType";
    }
    @RequestMapping("/editWorkType")
    public String editWorkType(){
        return "editWorkType";
    }
}
