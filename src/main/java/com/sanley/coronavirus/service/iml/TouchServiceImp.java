package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/2/24.
*/

import com.github.pagehelper.PageHelper;
import com.sanley.coronavirus.dao.TouchDao;
import com.sanley.coronavirus.entity.Touch;
import com.sanley.coronavirus.service.TouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouchServiceImp implements TouchService {
    @Autowired
    TouchDao dao;


    @Override
    public List<Touch> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void add(Touch touch) {
        dao.add(touch);
    }

    @Override
    public Touch findById(int baseId) {
        return dao.findById(baseId);
    }

    @Override
    public void toSafe(int baseId) {
        dao.toSafe(baseId);
    }

    @Override
    public Integer number() {
        Integer i = dao.number();
        if (i==null){
            return 0;
        }
        return i;
    }

    @Override
    public Integer currentNumber() {
        Integer i = dao.currentNumber();
        if (i==null){
            return 0;
        }
        return i;
    }
}
