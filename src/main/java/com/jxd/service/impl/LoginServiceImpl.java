package com.jxd.service.impl;

import com.jxd.dao.ILoginDao;
import com.jxd.model.UserLogin;
import com.jxd.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 10:35
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    ILoginDao loginDao;
    @Override
    public List<UserLogin> findUser(UserLogin userLogin) {
        return loginDao.findUser(userLogin);
    }

    @Override
    public boolean editPwd(String newpwd1, String newpwd2, String uname) {
        return loginDao.editPwd(newpwd1, newpwd2, uname);
    }
}
