package com.jxd.service.impl;

import com.jxd.dao.IStudentListDao;
import com.jxd.model.Student;
import com.jxd.service.IStudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Student> getStuByClass(Integer limit, Integer page, Integer classId,String sname) {
        return iStudentListDao.getStuByClass(limit,page,classId,sname);
    }

    @Override
    public List<Student> getAllStuByClass(Integer classId) {
        return iStudentListDao.getAllStuByClass(classId);
    }


}
