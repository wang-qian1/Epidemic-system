package com.sanley.coronavirus.util.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sanley.coronavirus.dao.NewsDao;
import com.sanley.coronavirus.dao.StatisticsDao;
import com.sanley.coronavirus.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

@Component
public class MyPipeline implements us.codecraft.webmagic.pipeline.Pipeline {
	@Autowired
	private StatisticsDao statisticsDao;
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private New news;
	@Autowired
	private Remarks remarks;
	@Autowired
	private Root root;
	@Autowired
	private Statistics globalstatistics,domesticStatistics,internationalStatistics;
	@Override
	public void process(ResultItems resultItems, Task task) {
		root = JSON.parseObject(resultItems.get("data").toString(), new TypeReference<Root>(){});
		init();
	}

	public void reSet() {
		newsDao.runcateRemarks();
		newsDao.runcateRumors();
		newsDao.runcateGoodsGuides();
		newsDao.runcateTimelines();
		newsDao.runcateRecommends();
	}

	public void init() {
		reSet();
		globalstatistics = root.getGlobalStatistics();
		globalstatistics.setPosition("GlobalStatistics");
		globalstatistics.setPositionCode("Global");
		domesticStatistics = root.getDomesticStatistics();
		domesticStatistics.setPosition("DomesticStatistics");
		domesticStatistics.setPositionCode("Domestic");
		internationalStatistics = root.getInternationalStatistics();
		internationalStatistics.setPosition("InternationalStatistics");
		internationalStatistics.setPositionCode("International");
		getStatistics(globalstatistics);
		getStatistics(domesticStatistics);
		getStatistics(internationalStatistics);
		getNews();
		getGoodsGuides();
		getRecommends();
		getTimelines();
	}

	public void getStatistics(Statistics statistics) {
		if (statisticsDao.find(statistics.getPositionCode())!= null){
			statisticsDao.update(statistics);
		} else {
			statisticsDao.add(statistics);
		}
	}

	public void getNews() {
		for (String item : root.getRemarks()) {
			String arr[] = item.split("：");
			remarks.setTitle(arr[0]);
			remarks.setContent(arr[1]);
			newsDao.addRemarks(remarks);
		}
		for (String item : root.getNotes()) {
			String arr[] = item.split("：");
			remarks.setTitle(arr[0]);
			remarks.setContent(arr[1]);
			newsDao.addRemarks(remarks);
		}
		for (Rumors rumors: root.getRumors()){
			newsDao.addRumors(rumors);
		}
		System.out.println("--------------------->"+root);
	}

	public void getGoodsGuides() {
		for (GoodsGuides goodsGuides: root.getGoodsGuides()) {
			goodsGuides.setContentImgUrls(goodsGuides.getContentImgUrls().substring(1,goodsGuides.getContentImgUrls().length()-1));
			newsDao.addGoodsGuides(goodsGuides);
		}
	}

	public void getRecommends() {
		for (Recommends recommends: root.getRecommends()) {
			newsDao.addRecommends(recommends);
		}
		for (Wikis wikis: root.getWikis()) {
			newsDao.addRecommends(wikis);
		}
		for (WHOArticle whoArticle: root.getWHOArticle()) {
			newsDao.addRecommends(whoArticle);
		}
	}

	public void getTimelines() {
		for (Timelines timelines: root.getTimelines()) {
			newsDao.addTimelines(timelines);
		}
	}
}
