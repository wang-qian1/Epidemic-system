package com.sanley.coronavirus.util.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UtilCareler {
	@Autowired
	private MyProcessor myProcessor;
	@Autowired
	private MyPipeline myPipeline;
	@Autowired
	private SpiderTask spiderTask;

	@Scheduled(cron = "0 0 16 * * ?")
	public void Util() {
		spiderTask.startSpider("http://111.231.75.86:8000/api/statistics/latest", myProcessor, myPipeline);
//		spiderTask.startSpider("http://111.231.75.86:8000/api/countries/daily", statisticsProcessor, statisticsPipeline);
	}
}
