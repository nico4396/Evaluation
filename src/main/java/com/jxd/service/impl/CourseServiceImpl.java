package com.jxd.service.impl;

import com.jxd.dao.ICourseDao;
import com.jxd.model.Course;
import com.jxd.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 15:10
 */
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    ICourseDao courseDao;

    @Override
    public Course getByCouid(Integer couid) {
        return courseDao.getByCouid(couid);
    }

    @Override
    public boolean editCourse(Course course) {
        return courseDao.editCourse(course);
    }

    @Override
    public List<Course> getAllCourses(Integer limit, Integer page, String couname) {
        return courseDao.getAllCourses(limit, page, couname);
    }

    @Override
    public List<Course> getAllCourse(String couname) {
        return courseDao.getAllCourse(couname);
    }

    @Override
    public boolean addCourses(Course course) {
        return courseDao.addCourses(course);
    }

    @Override
    public boolean deleteCourseByid(Integer couid) {
        return courseDao.deleteCourseByid(couid);
    }
}
