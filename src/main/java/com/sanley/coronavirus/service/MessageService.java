package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.Message;

import java.util.List;

public interface MessageService {
    //查询打卡资料
    public List<Message> getMessage(String username,String dateId);

    //删除打卡信息
    public void deleteByUsername(String username,String dateId);

    //更新打卡信息
    public void updateMessage(Message message);

    //每日打卡
    public boolean addMessage(Message message);
}
