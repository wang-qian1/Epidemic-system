package com.sanley.coronavirus.util.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sanley.coronavirus.dao.NewsDao;
import com.sanley.coronavirus.dao.StatisticsDao;
import com.sanley.coronavirus.entity.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;


@Component
public class MyPipeline implements us.codecraft.webmagic.pipeline.Pipeline {
	private String sel;

	public void setSel(String sel) {
		this.sel = sel;
	}

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
	private JSONArray dailyData;
	@Override
	public void process(ResultItems resultItems, Task task) {
		switch (sel){
			case "statistics" :
				root = JSON.parseObject(resultItems.get("data").toString(), new TypeReference<Root>(){});
				init();
				break;
			case "daily" :
				dailyData = JSON.parseArray(resultItems.get("daily").toString());
				statisticsDao.runcateDaily();
				getDailyData();
				break;
			case "provincesDaily" :
				dailyData = JSON.parseArray(resultItems.get("provincesDaily").toString());
				statisticsDao.runcateProvincesDaily();
				getProvincesDailyData();
				break;
			case "citiesDaily" :
				dailyData = JSON.parseArray(resultItems.get("citiesDaily").toString());
				statisticsDao.runcateCitiesDaily();
				getCitiesDailyData();
				break;
			default:
					break;
		}
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

	public void getDailyData() {
		for (Object object: dailyData) {
			DailyData dailyData = JSON.parseObject(object.toString(),new TypeReference<DailyData>(){});
			System.out.println("-------------->"+dailyData);
			statisticsDao.addDaily(dailyData);
		}
	}

	public void getProvincesDailyData() {
		for (Object object: dailyData) {
			ProvincesDaily provincesDaily = JSON.parseObject(object.toString(),new TypeReference<ProvincesDaily>(){});
			System.out.println("-------------->"+provincesDaily);
			statisticsDao.addProvincesDaily(provincesDaily);
		}
	}

	public void getCitiesDailyData() {
		for (Object object: dailyData) {
			CitiesDaily citiesDaily = JSON.parseObject(object.toString(),new TypeReference<CitiesDaily>(){});
			System.out.println("-------------->"+citiesDaily);
			statisticsDao.addCitiesDaily(citiesDaily);
		}
	}


}
