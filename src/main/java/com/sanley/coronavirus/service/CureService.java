package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.Cure;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface CureService {

    public void add(Cure cure);
    public List<Cure> findAll(int page,int size);
    public Cure get(int id);
    public void update(int baseId,String current);
    public int number();
    public List<Map<Integer,Date>> group();
    public int beforeDay(Date date);


}
