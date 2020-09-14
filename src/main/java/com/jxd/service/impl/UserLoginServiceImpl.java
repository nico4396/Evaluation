package com.jxd.service.impl;

import com.jxd.dao.IUserLoginDao;
import com.jxd.model.UserLogin;
import com.jxd.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 15:04
 */
@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    IUserLoginDao userLoginDao;
    @Override
    public List<UserLogin> getAllUsers(Integer limit, Integer page, String uname) {
        return userLoginDao.getAllUsers(limit, page, uname);
    }

    @Override
    public List<UserLogin> getAllUser(String uname) {
        return userLoginDao.getAllUser(uname);
    }

    @Override
    public boolean deleteUserByid(Integer uid) {
        return userLoginDao.deleteUserByid(uid);
    }

    @Override
    public boolean addUserLogin(UserLogin userLogin) {
        return userLoginDao.addUserLogin(userLogin);
    }

    @Override
    public UserLogin getByUid(Integer uid) {
        return userLoginDao.getByUid(uid);
    }

    @Override
    public boolean editUserLogin(UserLogin userLogin) {
        return userLoginDao.editUserLogin(userLogin);
    }
}
