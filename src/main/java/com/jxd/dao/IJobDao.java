package com.jxd.dao;

import com.jxd.model.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IJobDao {
    /**
     * @Description 编辑信息
     * @params [student]
     * @return boolean
     **/
    boolean editJob(Integer jid,String jname,@Param("deptname") String deptName);
    /**
    * @Description  根据编号查找信息
    * @params [jid]
    * @return com.jxd.model.Job
    **/
    Job getByJid(Integer jid);
    /**
     * @Description 显示所有
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Job> getAllJobs(Integer limit, Integer page, @Param("jname") String jname, @Param("deptname") String deptName);
    List<Job> getAllJob(@Param("jname") String jname, @Param("deptname") String deptName);
    /**
     * @Description  添加职位部门
     * @params [course]
     * @return boolean
     **/
    boolean addJobs(String jname,@Param("deptname") String deptName);
    /**
     * @Description  删除
     * @params [id]
     * @return boolean
     **/
    boolean deleteJobByid(Integer jid);
}

