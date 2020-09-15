package com.jxd.dao;

import com.jxd.model.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ILoginDao {
    /**
     * @Description 查找用户名密码是否存在
     * @params user
     * @return java.util.List<com.jxd.model.User>
     **/
    List<UserLogin> findUser(UserLogin userLogin);
    /**
    * @Description  重置密码
    * @params [newpwd1, newpwd2, uname]
    * @return boolean
    **/
    boolean editPwd(@Param("pwd") String newpwd1, String newpwd2, String uname);
}
