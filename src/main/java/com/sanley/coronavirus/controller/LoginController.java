package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/3/15.
*/

import com.sanley.coronavirus.dao.UserDao;
import com.sanley.coronavirus.entity.User;
import com.sanley.coronavirus.service.UserService;
import com.sanley.coronavirus.util.crawler.RandomValidateCodeUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8", method= RequestMethod.POST)
    public User toLogin(@RequestBody Map<String,String> map){
        return userService.userLogin(map.get("username"),map.get("password"));
    }

    @RequestMapping(value = "/register",produces = "application/json;charset=utf-8", method= RequestMethod.POST)
    @ResponseBody
    public String toRegister(@RequestBody User user){
        String username = user.getUsername();
        if (userService.findByUsername(username)==null){
            if(userService.addUser(user)){
                return "success";
            } else {
                return "error";
            }
        } else {
            return "repeat";
        }
    }
    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>> ", e);
        }
    }

    /**
     * 校验验证码
     */
    @RequestMapping(value = "/checkVerify", method = RequestMethod.GET)
    public boolean checkVerify(String code, HttpSession session) {
        try {
            //从session中获取随机数
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.equalsIgnoreCase(code)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("验证码校验失败", e);
            return false;
        }
    }
}
