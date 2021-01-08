package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/2/24.
*/

import com.sanley.coronavirus.dao.ManageDao;
import com.sanley.coronavirus.entity.Manage;
import com.sanley.coronavirus.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImp implements ManageService {
    @Autowired
    ManageDao dao;
    @Override
    public List<Manage> findAll() {
        return dao.findAll();
    }

    @Override
    public void add(Manage manage) {
        dao.add(manage);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void update(Manage manage) {
        dao.update(manage);
    }

    @Override
    public Manage find(String id, String password) {
        return dao.find(id,password);
    }
}
