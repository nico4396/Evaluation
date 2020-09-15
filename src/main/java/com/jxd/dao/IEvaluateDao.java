package com.jxd.dao;

import com.jxd.model.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEvaluateDao {
    /**
     * @Description 根据couid找信息
     * @params [uid]
     * @return com.jxd.model.UserLogin
     **/
    Evaluate getByEvaid(Integer evaid);
    /**
     * @Description 编辑信息
     * @params [student]
     * @return boolean
     **/
    boolean editWorkType(Evaluate evaluate);
    /**
     * @Description 显示所有科目
     * @params []
     * @return java.util.List<com.jxd.model.UserLogin>
     **/
    List<Evaluate> getAllEvaluates(Integer limit, Integer page, @Param("evaname") String evaname);
    List<Evaluate> getAllEvaluate(@Param("evaname") String evaname);
    /**
     * @Description  添加科目
     * @params [course]
     * @return boolean
     **/
    boolean addWorkTypes(Evaluate evaluate);
    /**
     * @Description  删除学科
     * @params [id]
     * @return boolean
     **/
    boolean deleteWorkTypeByid(Integer evaid);
}
