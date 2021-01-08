package com.sanley.coronavirus.dao;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.Inspect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InspectDao {
    //查看检测记录
    @Select("select testId ,baseId,testDate,ctTest,nuTest from inspect where baseId=#{baseId}")
    public List<Inspect> findById(int baseId);
    //添加核酸记录
    @Insert("insert into inspect(baseId,testDate,ctTest,nuTest)values(#{baseId},#{testDate},#{ctTest},#{nuTest})")
    public void add(Inspect inspect);

}
