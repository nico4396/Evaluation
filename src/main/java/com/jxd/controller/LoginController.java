package com.jxd.controller;

import com.jxd.model.UserLogin;
import com.jxd.service.ILoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * ClassName: LoginController
 * Description: TODO
 * author Dai Yinxiang
 * date: 2020/9/10 下午 3:40
 */
@Controller
@SessionAttributes({"uname","pwd"})
public class LoginController {
    @Autowired
    ILoginService loginService;

    @RequestMapping(value = "/editPwd", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String editPwd(@Param("pwd") String newpwd1, String newpwd2, String uname){
            if (newpwd1.equals(newpwd2)){
                boolean isEdit = loginService.editPwd(newpwd1, newpwd2, uname);
                if (isEdit){
                    return "修改成功";
                }else {
                    return "修改失败";
                }
            }else {
                return "两次新密码不相同";
            }
        }

    @RequestMapping(value = "/findUser", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findUser(String uname, String pwd, Model model) {
        UserLogin userLogin = new UserLogin(uname, pwd);
        List<UserLogin> list = loginService.findUser(userLogin);
        if (list.size() != 0) {
            model.addAttribute("uname", uname);
            model.addAttribute("pwd", pwd);
            if (list.get(0).getPower().equals("管理员")) {
                return "mindex";
            } else if (list.get(0).getPower().equals("教师")) {
                return "teacher";
            } else if (list.get(0).getPower().equals("项目经理")) {
                return "manager";
            } else {
                model.addAttribute("loginMsg", "用户名或密码错误");
                return "login";
            }
        } else {
            model.addAttribute("loginMsg", "不能为空");
            return "login";
        }
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/mindex")
    public String mindex() {
        return "../../WEB-INF/view/admin/mindex";
    }

    @RequestMapping("/repwd")
    public String repwd() {
        return "repwd";
    }

}
