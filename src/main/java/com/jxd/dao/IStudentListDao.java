package com.jxd.dao;

import com.jxd.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentListDao {
    /**
     * @param sid
     * @return com.jxd.model.Student
     * @Description TODO 根据学员id获取学员所有信息
     */
    Student getStuById(@Param("sid") Integer sid);

    /**
     * @param limit
     * @param page
     * @param classId
     * @param sname
     * @return java.util.List<com.jxd.model.Student>
     * @Description TODO 根据班级号和学生姓名模糊查找学生
     */
    List<Map<String, Object>> getStuByClass(@Param("limit") Integer limit, @Param("page") Integer page, @Param("classid") Integer classId, @Param("sname") String sname);

    /**
     * @return java.util.List<com.jxd.model.Student>
     * @Description TODO  获取所有学生
     */
    List<Map<String, Object>> getAllStu();

    /**
     * @param sid
     * @return java.util.List<com.jxd.model.Student>
     * @Description TODO 获取学生的学号和班期
     */
    List<Student> getStuEva(Integer sid);

    /**
     * @param sid
     * @return java.lang.String
     * @Description TODO 根据学号获取图片
     */
    String getImg(Integer sid);

    /**
     * @param sid
     * @param imgName
     * @return boolean
     * @Description TODO 按学号插入图片
     */
    boolean uploadImg(@Param("sid") Integer sid, @Param("imgName") String imgName);
}
