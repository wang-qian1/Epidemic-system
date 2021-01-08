package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/3/16.
*/

import com.sanley.coronavirus.dao.AuthenticationDao;
import com.sanley.coronavirus.entity.Authentication;
import com.sanley.coronavirus.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthenticationServiceImp implements AuthenticationService {
    @Autowired
    AuthenticationDao dao;
    @Override
    public List<Authentication> findByUserId(int userId) {
        return dao.findByUserId(userId);
    }
}
