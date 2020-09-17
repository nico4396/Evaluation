package com.jxd.service.impl;

import com.jxd.dao.IClassesDao;
import com.jxd.model.Classes;
import com.jxd.model.Teacher;
import com.jxd.service.IClassesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 15:28
 */
@Service
public class ClasserServiceImpl implements IClassesService {
    @Autowired
    IClassesDao classesDao;

    @Override
    public boolean checkName(@Param("classname") String classname) {
        return classesDao.checkName(classname);
    }

    @Override
    public List<Teacher> getAllTeaname() {
        return classesDao.getAllTeaname();
    }

    @Override
    public Classes getByClassid(Integer classid) {
        return classesDao.getByClassid(classid);
    }

    @Override
    public boolean editClass(Classes classes) {
        return classesDao.editClass(classes);
    }

    @Override
    public List<Classes> getAllClasses(Integer limit, Integer page, String classname) {
        return classesDao.getAllClasses(limit, page, classname);
    }

    @Override
    public List<Classes> getAllClass(String classname) {
        return classesDao.getAllClass(classname);
    }

    @Override
    public boolean addClasses(@Param("classname") String classname, @Param("teaid") Integer teaid) {
        return classesDao.addClasses(classname, teaid);
    }

    @Override
    public boolean deleteClassByid(Integer classid) {
        return classesDao.deleteClassByid(classid);
    }
}
