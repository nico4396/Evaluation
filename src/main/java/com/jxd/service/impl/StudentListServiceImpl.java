package com.jxd.service.impl;

import com.jxd.dao.IStudentListDao;
import com.jxd.model.Student;
import com.jxd.service.IStudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<Map<String,Object>> getStuByClass(Integer limit, Integer page, Integer classId, String sname) {
        return iStudentListDao.getStuByClass(limit,page,classId,sname);
    }

    @Override
    public List<Map<String,Object>> getAllStu() {
        return iStudentListDao.getAllStu();
    }

    @Override
    public List<Student> getStuEva(Integer sid) {
        return iStudentListDao.getStuEva(sid);
    }

    @Override
    public String getImg(Integer sid) {
        return iStudentListDao.getImg(sid);
    }

    @Override
    public boolean uploadImg(Integer sid, String imgName) {
        return iStudentListDao.uploadImg(sid,imgName);
    }


}
