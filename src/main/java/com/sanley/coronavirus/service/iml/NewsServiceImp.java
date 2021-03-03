package com.sanley.coronavirus.service.iml;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.dao.InspectDao;
import com.sanley.coronavirus.dao.NewsDao;
import com.sanley.coronavirus.entity.*;
import com.sanley.coronavirus.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImp implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public List<Remarks> findRemarks() {
        return newsDao.findRemarks();
    }

    @Override
    public List<GoodsGuides> findGoodsGuides() {
        return newsDao.findGoodsGuides();
    }

    @Override
    public List<Rumors> findRumors() {
        return newsDao.findRumors();
    }

    @Override
    public List<Recommends> findRecommends() {
        return newsDao.findRecommends();
    }

    @Override
    public List<Timelines> findTimelines() {
        return newsDao.findTimelines();
    }
}
