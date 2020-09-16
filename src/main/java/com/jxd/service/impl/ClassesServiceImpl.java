package com.jxd.service.impl;

import com.jxd.dao.IClassesDao;
import com.jxd.model.Classes;
import com.jxd.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 15:28
 */
@Service
public class ClassesServiceImpl implements IClassesService {
    @Autowired
    IClassesDao iClassesDao;
    @Override
    public List<Classes> getAllClass() {
        return iClassesDao.getAllClass();
    }
}
