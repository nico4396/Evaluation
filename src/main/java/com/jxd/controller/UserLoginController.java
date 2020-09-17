package com.jxd.controller;

import com.jxd.dao.IUserLoginDao;
import com.jxd.model.UserLogin;
import com.jxd.service.IUserLoginService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 15:05
 */
@Controller
@SessionAttributes({"userlogin"})
public class UserLoginController {
    @Autowired
    IUserLoginDao userLoginDao;
    @Autowired
    IUserLoginService userLoginService;

    /**
    * @Description  编辑用户信息
    * @params [uid, uname, pwd, power]
    * @return java.lang.String
    **/
    @RequestMapping(value = "/editUserLogin",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editUserLogin(UserLogin userLogin){
        userLogin = new UserLogin(userLogin.getUid(),userLogin.getUname(),userLogin.getPwd(),userLogin.getPower());
        boolean isEdit=userLoginService.editUserLogin(userLogin);
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
    @RequestMapping(value = "/getByUid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserLogin getByUid(Integer uid, Model model){
        UserLogin userlogin=userLoginDao.getByUid(uid);
        model.addAttribute("userlogin",userlogin);
        return userlogin;
    }

    /**
    * @Description  添加用户
    * @params [userLogin]
    * @return java.lang.String
    **/
    @RequestMapping(value = "/addUserLogin",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addUserLogin(UserLogin userLogin){
        boolean isadd = userLoginService.addUserLogin(userLogin);
        if (isadd){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
    * @Description 删除用户
    * @params [id]
    * @return java.lang.String
    **/
    @RequestMapping("/deleteUserByid")
    @ResponseBody
    public String deleteUserByid(Integer uid) {
        boolean isdelete = userLoginService.deleteUserByid(uid);
        if (isdelete){
            return  "删除成功";
        }else {
            return "删除失败";
        }

    }
    /**
    * @Description 显示所有用户
    * @params []
    * @return java.util.List<com.jxd.model.UserLogin>
    **/
    @RequestMapping(value = "/getAllUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getAllUser(Integer limit, Integer page, @Param("uname") String uname) {
        List<UserLogin> list = userLoginService.getAllUser(uname);
        page = (page-1)*limit;
        //分页查询
        List<UserLogin> list1 = userLoginService.getAllUsers(limit,page,uname);
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
    * @Description 用户页面
    * @params []
    * @return java.lang.String
    **/
    @RequestMapping("/userlogin")
    public String student() {
        return "../../WEB-INF/view/admin/user/userlogin";
    }

    /**
     * @Description 添加用户页面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/addUser")
    public String addUser(){
        return "../../WEB-INF/view/admin/user/addUser";
    }
    /**
     * @Description 添加用户页面
     * @params []
     * @return java.lang.String
     **/
    @RequestMapping("/editUser")
    public String editUser(){
        return "../../WEB-INF/view/admin/user/editUser";
    }
}
