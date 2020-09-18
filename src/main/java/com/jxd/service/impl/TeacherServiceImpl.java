package com.jxd.service.impl;

import com.jxd.dao.ITeacherDao;
import com.jxd.model.Teacher;
import com.jxd.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 16:59
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    ITeacherDao teacherDao;

    @Override
    public boolean checkClassToTeacher(Integer tid) {
        return teacherDao.checkClassToTeacher(tid);
    }

    @Override
    public Teacher getByTeaid(Integer teaid) {
        return teacherDao.getByTeaid(teaid);
    }

    @Override
    public boolean editTeacher(Teacher teacher) {
        return teacherDao.editTeacher(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers(Integer limit, Integer page, String teaname) {
        return teacherDao.getAllTeachers(limit, page, teaname);
    }

    @Override
    public List<Teacher> getAllTeacher(String teaname) {
        return teacherDao.getAllTeacher(teaname);
    }

    @Override
    public boolean addTeachers(Teacher teacher) {
        return teacherDao.addTeachers(teacher);
    }

    @Override
    public boolean deleteTeacherByid(Integer teaid) {
        return teacherDao.deleteTeacherByid(teaid);
    }
}
