package com.sanley.coronavirus.dao;/*
Created by shkstart on 2020/3/15.
*/

import com.sanley.coronavirus.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserDao {
    //通过username查找User
    @Select("select * from user where username=#{username}")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "unit", column = "unit")})
    public User findByUsername(String username);
    //添加用户
    @Insert("insert into user(username,password,phone,unit,name)values(#{username},#{password},#{phone},#{unit},#{name})")
    public int addUser(User user);

    //修改用户信息
    @Update("update user set password=#{password},phone=#{phone},name=#{name},unit=#{unit} where username=#{username}")
    public int updateUser(User user);

    //用户登录
    @Select("select * from user where username=#{username} and password=#{password}")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "unit", column = "unit")})
    public User userLogin(@Param("username") String username, @Param("password") String password);

    //查找所有用户
    @Select("select * from user")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "unit", column = "unit")})
    public List<User> findAll();

    //删除用户
    @Delete("delete from user where username=#{username}")
    public int deleteUser(String username);

    //为账号添加用户权限
    @Insert("insert into user_authorities(authentication_id,user_id)values(2,#{user_id})")
    public void addUserRole(int id);
    //为账号添加超级管理者权限
    @Insert("insert into user_authorities(authentication_id,user_id)values(1,#{user_id})")
    public void addAdminRole(int id);

}
