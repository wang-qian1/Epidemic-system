package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.dao.InspectDao;
import com.sanley.coronavirus.entity.Inspect;
import com.sanley.coronavirus.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InspectServiceImp implements InspectService {
    @Autowired
    InspectDao dao;
    @Override
    public List<Inspect> find(int baseId) {
        return dao.findById( baseId);
    }

    @Override
    public void add(Inspect inspect) {
        dao.add(inspect);
    }
}
