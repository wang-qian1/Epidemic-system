package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/2/24.
*/

import com.sanley.coronavirus.dao.MessageDao;
import com.sanley.coronavirus.entity.Message;
import com.sanley.coronavirus.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    MessageDao messageDao;

    @Override
    public List<Message> getMessage(String username,String dateId) {
        return messageDao.findMessage(username,dateId);
    }

    @Override
    public void deleteByUsername(String username, String dateId) {
        messageDao.deleteByUsername(username,dateId);
    }

    @Override
    public void updateMessage(Message message) {
        messageDao.updateMessage(message);
    }

    @Override
    public boolean addMessage(Message message) {
        if (messageDao.addMessage(message)>0){
            return true;
        } else {
            return false;
        }
    }
}
