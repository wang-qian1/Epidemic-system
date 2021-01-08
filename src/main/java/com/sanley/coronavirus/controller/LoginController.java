package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/3/15.
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String tologin(){
        return "login";
    }
}
