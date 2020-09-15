package com.jxd.service.impl;

import com.jxd.dao.IEvaluateDao;
import com.jxd.model.Evaluate;
import com.jxd.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DengRuJia
 * @Date 2020.09.12 15:25
 */
@Service
public class EvaluateServiceImpl  implements IEvaluateService {
    @Autowired
    IEvaluateDao evaluateDao;
    @Override
    public Evaluate getByEvaid(Integer evaid) {
        return evaluateDao.getByEvaid(evaid);
    }

    @Override
    public boolean editWorkType(Evaluate evaluate) {
        return evaluateDao.editWorkType(evaluate);
    }

    @Override
    public List<Evaluate> getAllEvaluates(Integer limit, Integer page, String evaname) {
        return evaluateDao.getAllEvaluates(limit, page, evaname);
    }

    @Override
    public List<Evaluate> getAllEvaluate(String evaname) {
        return evaluateDao.getAllEvaluate(evaname);
    }


    @Override
    public boolean addWorkTypes(Evaluate evaluate) {
        return evaluateDao.addWorkTypes(evaluate);
    }

    @Override
    public boolean deleteWorkTypeByid(Integer evaid) {
        return evaluateDao.deleteWorkTypeByid(evaid);
    }
}
