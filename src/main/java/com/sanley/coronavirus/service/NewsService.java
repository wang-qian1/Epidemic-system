package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.*;
import java.util.List;

public interface NewsService {
    public List<Remarks> findRemarks();
    public List<GoodsGuides> findGoodsGuides();
    public List<Rumors> findRumors();
    public List<Recommends> findRecommends();
    public List<Timelines> findTimelines();
}
