package com.jxd.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:44
 */
public class ManagerEvaController {
    @RequestMapping("/studentInfo2")
    //@ResponseBody
    public String studentInfo2(){
        return "studentInfo2";
    }
}
