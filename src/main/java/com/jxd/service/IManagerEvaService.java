package com.jxd.service;

import com.jxd.model.Classes;
import com.jxd.model.Student;
import com.jxd.model.TurnWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:42
 */
public interface IManagerEvaService {
    List<Student> getAllStudent(String sname,Integer jid);
    //分页查询
    List<Student> getStudentByPage(@Param("pageSize") Integer pageSize, @Param("page") Integer page, @Param("sname") String sname, @Param("jid") Integer jid);
    //获取所有的班期名
    List<Classes> getClassesName();

    //转正评价
    boolean evaTurnWork(TurnWork turnWork);
}
