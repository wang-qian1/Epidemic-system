package com.sanley.coronavirus.controller;/*
Created by wangqian on 2021/3/3.
*/

import com.sanley.coronavirus.entity.Message;
import com.sanley.coronavirus.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    //添加每日打卡信息
    @RequestMapping(value="/message/add",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
    public boolean addMessage(@RequestBody Map<String,Message> map){
        if (messageService.addMessage(map.get("message"))){
            return true;
        } else {
            return false;
        }
    }

    //更新每日打卡信息
    @RequestMapping(value="/message/update",method=RequestMethod.POST)
    public void updateMessage(@RequestBody Message message){
        messageService.updateMessage(message);
    }
    //删除每日打卡信息
    @RequestMapping(value="/message/delete",method=RequestMethod.GET)
    public void deleteMessage(@RequestParam("username")String username,@RequestParam("dateId")String dateId){
        messageService.deleteByUsername(username,dateId);
    }
    //查找每日打卡信息
    @RequestMapping(value="/message/find",method=RequestMethod.GET)
    public List<Message> findMessage(@RequestParam("username")String username, @RequestParam("dateId")String dateId){
        return messageService.getMessage(username,dateId);
    }
    //跳转添加页面
//    @RequestMapping(value = "/touch/toAdd")
//    public String toAdd(){
//        return "touchAdd";
//    }
}
