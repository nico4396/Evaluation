package com.jxd.service.impl;

import com.jxd.dao.IManagerEvaDao;
import com.jxd.model.Classes;
import com.jxd.model.Student;
import com.jxd.model.TurnWork;
import com.jxd.service.IManagerEvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.13 10:42
 */
@Service
public class ManagerEvaServiceImpl implements IManagerEvaService {
    @Autowired
    IManagerEvaDao managerEvaDao;
    @Override
    public List<Student> getAllStudent(String sname,Integer jid) {
        return managerEvaDao.getAllStudent(sname,jid);
    }

    @Override
    public List<Student> getStudentByPage(Integer pageSize, Integer page, String sname,Integer jid) {
        return managerEvaDao.getStudentByPage(pageSize,page,sname,jid);
    }

    @Override
    public List<Classes> getClassesName() {
        return managerEvaDao.getClassesName();
    }

    @Override
    public boolean evaTurnWork(TurnWork turnWork) {
        return managerEvaDao.evaTurnWork(turnWork);
    }

    @Override
    public Student getById(Integer sid) {
        return managerEvaDao.getById(sid);
    }
}
