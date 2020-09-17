package com.jxd.service.impl;

import com.jxd.dao.IStudentDao;
import com.jxd.model.Classes;
import com.jxd.model.Student;
import com.jxd.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 17:04
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Addressing
    IStudentDao studentDao;

    @Override
    public boolean checkMark(Integer sid) {
        return studentDao.checkMark(sid);
    }

    @Override
    public boolean addJobToStudent(Integer jid,Integer sid) {
        return studentDao.addJobToStudent(jid,sid);
    }

    @Override
    public List<Classes> getAllClassname() {
        return studentDao.getAllClassname();
    }

    @Override
    public Student getBySid(Integer sid) {
        return studentDao.getBySid(sid);
    }

    @Override
    public boolean editStudent(Student student) {
        return studentDao.editStudent(student);
    }

    @Override
    public List<Student> getAllStudentsAmd(Integer limit, Integer page, String sname,@Param("classname") String classname) {
        return studentDao.getAllStudentsAmd(limit, page, sname,classname);
    }

    @Override
    public List<Student> getAllStudentAmd(String sname,@Param("classname") String classname) {
        return studentDao.getAllStudentAmd(sname,classname);
    }

    @Override
    public boolean addStudents(Student student) {
        return studentDao.addStudents(student);
    }

    @Override
    public boolean deleteStudentByid(Integer sid) {
        return studentDao.deleteStudentByid(sid);
    }

    @Override
    public boolean checkClassname(@Param("classid") Integer classid) {
        return studentDao.checkClassname(classid);
    }

    @Override
    public boolean checkStudent(Integer sid) {
        return studentDao.checkStudent(sid);
    }
}
