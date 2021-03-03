package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/3/16.
*/

import com.sanley.coronavirus.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //用户登录
    public  User userLogin(String username,String password);
    //修改用户信息
    public Boolean updateUser(User user);
    //根据账号查找用户
    public User findByUsername(String username);
    //添加用户
    public Boolean addUser(User user);
    //删除用户
    public Boolean deleteUser(String username);
    //查找所有用户
    public List<User> findAll(int page,int size);
    //添加普通用户
    public void addUserRole(int id);

    //为账号添加超级管理者权限
    public void addAdminRole(int id);

}
