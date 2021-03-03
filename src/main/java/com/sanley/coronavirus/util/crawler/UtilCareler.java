package com.sanley.coronavirus.util.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UtilCareler {
	@Autowired
	private SpiderTask spiderTask;

	@Scheduled(cron = "0 0 16 * * ?")
	public void Util() {
//		spiderTask.startSpider("http://111.231.75.86:8000/api/statistics/latest", "statistics");
//		spiderTask.startSpider("http://111.231.75.86:8000/api/countries/CHN/daily", "daily");
//		spiderTask.startSpider("http://111.231.75.86:8000/api/provinces/CHN/daily", "provincesDaily");
		spiderTask.startSpider("http://111.231.75.86:8000/api/cities/CHN", "citiesDaily");
	}
}
