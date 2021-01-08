package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.dao.DeadDao;
import com.sanley.coronavirus.entity.Cure;
import com.sanley.coronavirus.entity.Dead;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DeadService {
    public void add(Dead dead);
    public List<Dead> findAll(int page,int size);
    public Dead get(int id);
    public int number();

}
