package com.sanley.coronavirus;/*
Created by shkstart on 2020/3/9.
*/

import com.sanley.coronavirus.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

public class test {

    public static void main(String[] args) {

        Date date=new Date(System.currentTimeMillis());
        System.out.println(date.getTime());
    for (int i=4;i>=0;i--){
        System.out.println(new Date(System.currentTimeMillis()-(i*86400000)));

    }



    }
}
