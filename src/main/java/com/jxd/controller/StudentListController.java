package com.jxd.controller;

import com.jxd.model.Classes;
import com.jxd.model.Student;
import com.jxd.service.IClassesService;
import com.jxd.service.IStudentListService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:39
 */
@Controller
@SessionAttributes({"student","students","clist","imgName"})
public class StudentListController {
    @Autowired
    IStudentListService iStudentListService;

    @Autowired
    IClassesService classesService;

    @RequestMapping("/getStu")
    public String getStuById(Integer sid,Model model) {
        Student student = iStudentListService.getStuById(sid);
        model.addAttribute("student",student);
        return "studentInfo";
    }
    @RequestMapping("/stuList")
    public String stuList(Model model){
        List<Classes> clist = classesService.getAllClassList();
        model.addAttribute("clist",clist);
       return  "stuList";
    }

    @RequestMapping(value = "/getStuList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getStuByClass(Integer limit, Integer page, Integer classId,String sname){
        List<Map<String,Object>> list = iStudentListService.getAllStu();
        page=(page-1)*limit;
            List<Map<String,Object>> list1 = iStudentListService.getStuByClass(limit,page,classId,sname);
        JSONArray jsonArray = JSONArray.fromObject(list1);
        //创建json对象，用于返回layui表格需要的数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",list.size());//一共有多少条数据
        jsonObject.put("data",jsonArray);
        return jsonObject;
    }
    @RequestMapping("/getImg")
    @ResponseBody
    public String getImg(Integer sid){
        String iname = iStudentListService.getImg(sid);
        return iname;
    }

    @RequestMapping("/getStuEva")
    @ResponseBody
    public List<Student> getStuEva(Integer sid){
        List<Student> list = iStudentListService.getStuEva(202001);
        return list;
    }

    @RequestMapping(value = "/uploadFile",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String uploadFile(@RequestParam("upload") MultipartFile multipartFile, HttpServletRequest request,Model model){
        //创建一个目录files，用于存放上传的文件
        String savePath = request.getServletContext().getRealPath("files");
        File file = new File(savePath);

        //如果files不存在，或者不是目录，我们创建它
        if (!file.exists() || !file.isDirectory()){
            file.mkdir();
        }

        //获取原文件名 xxx.png
        String oldName = multipartFile.getOriginalFilename();
        //对原文件名进行处理
        String newName = UUID.randomUUID() +"_"+ oldName/*.substring(oldName.lastIndexOf("."))*/;

        //根据保存路径和新名字生成一个文件对象
        File saveFile = new File(savePath,newName);

        try {
            //将SpringMVC接收到的文件对象转换为普通的文件对象
            //转换的过程即保存的过程
            multipartFile.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("imgName",newName);
        //返回文件保存路径及文件名，以便删除时使用
        return /*"files/" + */newName;
    }

    @RequestMapping("/upload")
    public String upload(Integer sid,String imgName){
        boolean isUpload = iStudentListService.uploadImg(sid,imgName);
        return "remove";
    }
}
