package com.sanley.coronavirus.dao;/*
Created by shkstart on 2020/2/22.
*/

import com.sanley.coronavirus.entity.Hospital;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HospitalDao {
    //查找所有医院
    @Select("select id,name,address,phone from hospital")
    public List<Hospital> findAll();
    //添加医院
    @Insert("insert into hospital(name,address,phone)values(#{name},#{adderss},#{phone})")
    public boolean add(Hospital hospital);
    //根据名字查找医院
    @Select("select id,name,address,phone from hospital where name like #{name} ")
    public List<Hospital> findByName(String name);
    //更改医院信息
    @Update("update hospital set name=#{name},address=#{address},phone=#{phone} where id=#{id}")
    public boolean update(Hospital hospital);
}
