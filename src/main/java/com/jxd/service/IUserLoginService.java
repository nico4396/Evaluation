package com.jxd.service;

import com.jxd.model.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserLoginService {
    /**
    * @Description 显示所有用户
    * @params []
    * @return java.util.List<com.jxd.model.UserLogin>
    **/
    List<UserLogin> getAllUsers(Integer limit, Integer page, @Param("uname") String uname);
    List<UserLogin> getAllUser(@Param("uname") String uname);
    /**
     * @Description  删除用户
     * @params [id]
     * @return boolean
     **/
    boolean deleteUserByid(Integer uid);

    /**
    * @Description  添加用户
    * @params [userLogin]
    * @return boolean
    **/
    boolean addUserLogin(UserLogin userLogin);
    /**
    * @Description 根据用户uid找信息
    * @params [uid]
    * @return com.jxd.model.UserLogin
    **/
    UserLogin getByUid(Integer uid);

    /**
    * @Description 编辑信息
    * @params [student]
    * @return boolean
    **/
    boolean editUserLogin(UserLogin userLogin);
}
