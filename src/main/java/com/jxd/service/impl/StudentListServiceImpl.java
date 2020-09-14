package com.jxd.service.impl;

import com.jxd.dao.IStudentListDao;
import com.jxd.model.Student;
import com.jxd.service.IStudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:37
 */
@Service
public class StudentListServiceImpl implements IStudentListService {
    @Autowired
    IStudentListDao iStudentListDao;
    @Override
    public Student getStuById(Integer sid) {
        return iStudentListDao.getStuById(sid);
    }
}
