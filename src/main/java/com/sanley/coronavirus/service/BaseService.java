package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.Base;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BaseService {
    //查找所有基本信息
    public List<Base> findAll();

    public Base findById(int id);

    public void  delete(int id);

    public void add(Base base);

    public Base findByIdCard(String idCard);

    public void update(Base base);
}
