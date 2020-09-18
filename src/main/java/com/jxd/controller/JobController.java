package com.jxd.controller;

import com.jxd.dao.IJobDao;
import com.jxd.model.Job;
import com.jxd.service.IJobService;
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
 * @Date 2020.09.12 17:01
 */
@Controller
@SessionAttributes({"job"})
public class JobController {
    @Autowired
    IJobDao jobDao;
    @Autowired
    IJobService jobService;
    /**
     * @Description  编辑信息
     * @params [uid, uname, pwd, power]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/editJobMethod",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editJob(Integer jid,String jname,@Param("deptname") String deptName){
        boolean isEdit=jobService.editJob(jid, jname, deptName);
        if (isEdit) {
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
    /**
     * @Description  根据jid获取用户信息
     * @params [uid, model]
     * @return com.jxd.model.UserLogin
     **/
    @RequestMapping(value = "/getByJid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Job getByJid(Integer jid, Model model){
        Job job=jobDao.getByJid(jid);
        model.addAttribute("job",job);
        return job;
    }
    /**
     * @Description 删除科目
     * @params [id]
     * @return java.lang.String
     **/
    @RequestMapping("/deleteJobByid")
    @ResponseBody
    public String deleteJobByid(Integer jid) {
        boolean isdelete = jobService.deleteJobByid(jid);
        if (isdelete){
            return  "删除成功";
        }else {
            return "删除失败";
        }

    }
    /**
     * @Description 显示所有课程
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    @RequestMapping(value = "/getAllJob",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllCourse(Model model,Integer limit, Integer page, @Param("jname") String jname, @Param("deptname") String deptName) {
        List<Job> list = jobService.getAllJob(jname,deptName);
        page = (page-1)*limit;

        //分页查询
        List<Job> list1 = jobService.getAllJobs(limit,page,jname,deptName);
        //将list转换为json数组
        JSONArray jsonArray = JSONArray.fromObject(list1);
        //创建json对象，用于返回layui表格需要的数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg", "");
        jsonObject.put("count", list.size());
        jsonObject.put("data", jsonArray);
        model.addAttribute("jsonObject",jsonObject);
        return jsonObject ;
    }
    /**
     * @Description  添加职位部门
     * @params [userLogin]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/addJobs",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addJobs(String jname,@Param("deptname") String deptName){
        boolean isadd = jobService.addJobs(jname, deptName);
        if (isadd){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * @Description 页面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/jobList")
    public String jobList() {
        return "../../WEB-INF/view/admin/job/jobList";
    }

    /**
     * @Description 添加页面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/addJob")
    public String addJob(){
        return "../../WEB-INF/view/admin/job/addJob";
    }
    /**
     * @Description 编辑页面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/editJob")
    public String editJob(){
        return "../../WEB-INF/view/admin/job/editJob";
    }
}
