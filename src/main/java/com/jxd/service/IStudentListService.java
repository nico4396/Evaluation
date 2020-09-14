package com.jxd.service;

import com.jxd.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentListService {
    /**
     * @param sid
     * @return com.jxd.model.Student
     * @Description TODO 根据学员id获取学员所有信息
     */
    Student getStuById(Integer sid);

    /**
     * @param limit
     * @param page
     * @param classId
     *  @param sname
     * @return java.util.List<com.jxd.model.Student>
     * @Description TODO 根据班级号和学生姓名模糊查找学生
     */
    List<Student> getStuByClass(@Param("limit") Integer limit, @Param("page") Integer page, @Param("classId") Integer classId,@Param("sname") String sname);

    /**
     * @return java.util.List<com.jxd.model.Student>
     * @Description TODO  获取该班级的所有学生
     */
    List<Student> getAllStuByClass(Integer classId);
}
