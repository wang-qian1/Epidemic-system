package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/2/24.
*/

import com.sanley.coronavirus.entity.Manage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ManageService {
     List<Manage> findAll();


    public void add(Manage manage);

    public void delete(String id);

    public void update(Manage manage);

    public Manage find(String id,String password);
}
