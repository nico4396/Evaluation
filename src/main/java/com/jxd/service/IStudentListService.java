package com.jxd.service;

import com.jxd.model.Student;

public interface IStudentListService {
    /**
     * @param sid
     * @return com.jxd.model.Student
     * @Description TODO 根据学员id获取学员所有信息
     */
    Student getStuById(Integer sid);
}
