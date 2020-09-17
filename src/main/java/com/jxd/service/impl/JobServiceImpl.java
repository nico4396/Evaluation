package com.jxd.service.impl;

import com.jxd.dao.IJobDao;
import com.jxd.model.Job;
import com.jxd.service.IJobService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 17:01
 */
@Service
public class JobServiceImpl implements IJobService {
    @Autowired
    IJobDao jobDao;

    @Override
    public boolean editJob(Integer jid,String jname,@Param("deptname") String deptName) {
        return jobDao.editJob(jid, jname, deptName);
    }

    @Override
    public List<Job> getAllJobs(Integer limit, Integer page, String jname, String deptName) {
        return jobDao.getAllJobs(limit, page, jname, deptName);
    }

    @Override
    public List<Job> getAllJob(String jname, String deptName) {
        return jobDao.getAllJob(jname, deptName);
    }

    @Override
    public boolean addJobs(String jname,@Param("deptname") String deptName) {
        return jobDao.addJobs(jname, deptName);
    }

    @Override
    public boolean deleteJobByid(Integer jid) {
        return jobDao.deleteJobByid(jid);
    }

    @Override
    public Job getByJid(Integer jid) {
        return jobDao.getByJid(jid);
    }
}
