package com.jxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: LoginController
 * Description: TODO
 * author Dai Yinxiang
 * date: 2020/9/10 下午 3:40
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(){
        return "login";
    }
    @RequestMapping("/stu")
    public String stuInfo(){
        return "studentInfo";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }
}
