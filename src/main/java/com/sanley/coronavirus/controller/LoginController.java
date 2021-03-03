package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/3/15.
*/

import com.sanley.coronavirus.dao.UserDao;
import com.sanley.coronavirus.entity.User;
import com.sanley.coronavirus.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public User toLogin(@RequestParam("username")String username, @RequestParam("password")String password){
        return userService.userLogin(username,password);
    }

    @RequestMapping(value = "/register",produces = "application/json;charset=utf-8", method= RequestMethod.POST)
    @ResponseBody
    public String toRegister(User user){
        String username = user.getUsername();
        if (userService.findByUsername(username)==null){
            if(userService.addUser(user)){
                return "注册成功";
            } else {
                return "注册失败";
            }
        } else {
            return "该用户名已被注册";
        }
    }
}
