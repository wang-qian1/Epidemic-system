package com.sanley.coronavirus.dao;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.Source;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SourceDao {
    @Select("select id ,name,type,number,hospitalId from source where hospitalId=#{hospitalId} ")
    public List<Source> findByHospitalId(int hospitalId);

    @Delete("delete from source where id=#{id}")
    public void deleteByid(int id);

    @Insert("insert into source(name,type,number,hospitalId) values(#{name},#{type},#{number},#{hospitalId})")
    public void addSource(Source source);

    @Update("update source set name=#{name},type=#{type},number=#{number} where id=#{id}")
    public void update(Source source);
}
