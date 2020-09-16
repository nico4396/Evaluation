package com.jxd.dao;

import com.jxd.model.Classes;

import java.util.List;

public interface IClassesDao {

    /**
     * @return java.util.List<com.jxd.model.Classes>
     * @Description TODO 获取所有班级信息
     */
    List<Classes> getAllClass();
}
