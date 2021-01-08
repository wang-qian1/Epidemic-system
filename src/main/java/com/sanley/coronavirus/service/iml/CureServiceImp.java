package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/2/23.
*/

import com.github.pagehelper.PageHelper;
import com.sanley.coronavirus.dao.CureDao;
import com.sanley.coronavirus.entity.Cure;
import com.sanley.coronavirus.service.CureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class CureServiceImp implements CureService {
    @Autowired
    CureDao dao;
    @Override
    public void add(Cure cure) {
        dao.add(cure);
    }

    @Override
    public List<Cure> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }


    @Override
    public Cure get(int id) {


        Cure cure = dao.findById(id);
        return cure;
    }

    @Override
    public void update(int baseId, String current) {
        dao.update(baseId,current);
    }

    @Override
    public int number() {
        return dao.number();
    }

    @Override
    public List<Map<Integer,Date>> group() {
        return dao.group();
    }

    @Override
    public int beforeDay(Date date) {
        return dao.beforeDay(date);
    }


}
