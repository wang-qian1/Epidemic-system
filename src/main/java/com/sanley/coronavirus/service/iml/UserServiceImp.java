package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/3/16.
*/

import com.github.pagehelper.PageHelper;
import com.sanley.coronavirus.dao.UserDao;
import com.sanley.coronavirus.entity.User;
import com.sanley.coronavirus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public List<User> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void addUserRole(int id) {
        dao.addUserRole(id);
    }

    @Override
    public void addAdminRole(int id) {
        dao.addAdminRole(id);
    }
}
