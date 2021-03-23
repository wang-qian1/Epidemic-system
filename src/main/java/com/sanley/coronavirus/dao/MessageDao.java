package com.sanley.coronavirus.dao;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MessageDao {

    @Select({"<script>",
            "select * from message",
            "where username=#{username}",
            "<when test='dateId!=null and dateId!= \"\"'>",
            "and dateId=#{dateId}",
            "</when>",
            "</script>"})
    public List<Message> findMessage(@Param("username") String username,@Param("dateId") String dateId);

    @Delete("delete from message where username=#{username} and dateId=#{dateId}")
    public void deleteByUsername(@Param("username") String username,@Param("dateId") String dateId);

    @Insert("insert into message values(#{dateId},#{username},#{temperature1},#{temperature2},#{state},#{temperature},#{healthCode},#{position})")
    public int addMessage(Message message);

    @Update("update message set temperature1=#{temperature1},temperature2=#{temperature2},state=#{state},temperature=#{temperature},healthCode=#{healthCode},position=#{position},dateId=#{dateId} where username=#{username} and dateId=#{dateId}")
    public void updateMessage(Message message);
}
