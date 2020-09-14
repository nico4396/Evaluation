package com.jxd.dao;

import com.jxd.model.Student;
import org.apache.ibatis.annotations.Param;

public interface IStudentListDao {
    /**
     * @param sid
     * @return com.jxd.model.Student
     * @Description TODO 根据学员id获取学员所有信息
     */
    Student getStuById(@Param("sid") Integer sid);
}
