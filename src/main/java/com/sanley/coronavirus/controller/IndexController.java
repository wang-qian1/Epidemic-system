package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/3/12.
*/

import com.sanley.coronavirus.entity.*;
import com.sanley.coronavirus.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class IndexController {
    @Autowired
    StatisticsService statisticsService;
    @Autowired
    MyUserDetailService userDetailService;


    @RequestMapping(value = "/getAllStatistics")
    public List<Statistics> getAllStatistics(){
        return statisticsService.getAllStatistics();
    }

    @RequestMapping(value = "/getStatistics")
    public Statistics getStatistics(String positon){
        return statisticsService.getStatistics(positon);
    }

    @RequestMapping(value = "/getDailyData")
    public List<DailyData> getDailyData(@RequestParam("startTime") int startTime, @RequestParam("endTime") int endTime){
        return statisticsService.getDailyByTime(startTime,endTime);
    }

    @RequestMapping(value = "/getProvincesDailyByTime")
    public List<ProvincesDaily> getProvincesDailyByTime(@RequestParam("provinceCode") String provinceCode, @RequestParam("startTime") int startTime, @RequestParam("endTime") int endTime){
        return statisticsService.getProvincesDailyByTime(provinceCode,startTime,endTime);
    }

    @RequestMapping(value = "/getCitiesDailyByCitiesName")
    public CitiesDaily getCitiesDailyByCitiesName(String citiesName){
        return statisticsService.getCitiesDailyByCitiesName(citiesName);
    }


}

