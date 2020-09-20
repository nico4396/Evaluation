package com.jxd.service.impl;

import com.jxd.dao.ISelectCourseDao;
import com.jxd.model.Classes;
import com.jxd.model.SelectCourse;
import com.jxd.service.ISelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public boolean addByBatchClass(@RequestParam("list") List<SelectCourse> list, Integer classid) {
        return selectCourseDao.addByBatchCourse(list);
    }

    @Override
    public boolean deleteSCourseByid(Integer id) {
        return selectCourseDao.deleteSCourseByid(id);
    }

    @Override
    public List<Classes> getAllSelectCourses(Integer limit, Integer page, String classname,String couname) {
        return selectCourseDao.getAllSelectCourses(limit, page, classname,couname);
    }

    @Override
    public List<Classes> getAllSelectCourse(String classname,String couname) {
        return selectCourseDao.getAllSelectCourse(classname,couname);
    }
}
