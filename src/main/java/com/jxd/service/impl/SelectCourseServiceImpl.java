package com.jxd.service.impl;

import com.jxd.dao.ISelectCourseDao;
import com.jxd.model.Classes;
import com.jxd.service.ISelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 16:57
 */
@Service
public class SelectCourseServiceImpl implements ISelectCourseService {
    @Autowired
    ISelectCourseDao selectCourseDao;

    @Override
    public List<Classes> getAllSelectCourses(Integer limit, Integer page, String classname,String couname) {
        return selectCourseDao.getAllSelectCourses(limit, page, classname,couname);
    }

    @Override
    public List<Classes> getAllSelectCourse(String classname,String couname) {
        return selectCourseDao.getAllSelectCourse(classname,couname);
    }
}
