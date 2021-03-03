package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/2/24.
*/

import com.sanley.coronavirus.entity.*;
import com.sanley.coronavirus.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping(value="/News/getGoodsGuides",method=RequestMethod.GET)
    public List<GoodsGuides> getGoodsGuides() {
        return newsService.findGoodsGuides();
    }

    @RequestMapping(value="/News/getRecommends",method=RequestMethod.GET)
    public List<Recommends> getRecommends() {
        return newsService.findRecommends();
    }

    @RequestMapping(value="/News/getRemarks",method=RequestMethod.GET)
    public List<Remarks> getRemarks() {
        return newsService.findRemarks();
    }

    @RequestMapping(value="/News/getRumors",method=RequestMethod.GET)
    public List<Rumors> getRumors() {
        return newsService.findRumors();
    }

    @RequestMapping(value="/News/getTimelines",method=RequestMethod.GET)
    public List<Timelines> getTimelines() {
        return newsService.findTimelines();
    }

}
