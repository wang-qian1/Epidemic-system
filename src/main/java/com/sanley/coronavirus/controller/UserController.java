package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/3/16.
*/


import com.github.pagehelper.PageInfo;
import com.sanley.coronavirus.entity.Cure;
import com.sanley.coronavirus.entity.User;
import com.sanley.coronavirus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/manager/list" ,method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<User> users = userService.findAll(page, size);
        PageInfo<User> pageInfo=new PageInfo(users);
        model.addAttribute("pageInfo",pageInfo);
        return "managerlist";
    }

    //跳转添加页面
    @RequestMapping(value = "/manager/toAdd")
    public String toAdd(){
        return "managerAdd";
    }

    //添加管理员功能
    @RequestMapping(value = "/manager/add",method = RequestMethod.POST)
    public String add(@RequestParam("username")String username, @RequestParam("name")String name,
                      @RequestParam("password")String password, @RequestParam("unit")String unit,
                      @RequestParam("phone") BigInteger phone, @RequestParam("supermanager")char supermanager){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密密码
        String pwd=bCryptPasswordEncoder.encode(password);
        User user=new User().setName(name).setPassword(pwd).setUsername(username).setPhone(phone).setUnit(unit);
        System.out.println(user);
        //添加用户
        userService.addUser(user);
        //找到id
        int id = userService.findByUsername(user.getUsername()).getId();
        //添加普通权限
        userService.addUserRole(id);
        //添加超级管理员权限
        if ("是".equals(supermanager)){
            userService.addAdminRole(id);
        }
        return "redirect:/manager/list";
    }

    //升级权限
    @RequestMapping("/manager/toSuper/{id}")
    public String toSuper(@PathVariable("id")int id){
        userService.addAdminRole(id);
        return "redirect:/manager/list";
    }
    //删除用户
    @RequestMapping("/manager/delete/{id}")
    public String delete(@PathVariable("id")int id){
        userService.deleteUser(id);
        return "redirect:/manager/list";
    }

}
