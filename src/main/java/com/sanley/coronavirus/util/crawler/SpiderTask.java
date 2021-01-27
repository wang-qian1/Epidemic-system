package com.sanley.coronavirus.util.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.RedisScheduler;

@EnableScheduling
@Controller
public class SpiderTask {
	@Autowired
	private MyProcessor myProcessor;
	@Autowired
	private MyPipeline myPipeline;

	public void startSpider() {
		System.out.println(myProcessor);
		Spider.create(myProcessor)
						.addUrl("http://111.231.75.86:8000/api/statistics/latest")
						//Scheduler过滤器,使用redis过滤器
						.setScheduler(new QueueScheduler()
										.setDuplicateRemover(new BloomFilterDuplicateRemover(10000000))) //参数设置需要对多少条数据去重
						.addPipeline(new JsonFilePipeline())        //设置结果 以Json格式输出
						.addPipeline(myPipeline)        //设置结果 以Json格式输出
						.thread(3)//开三个线程，根据需求设置
						.run();
	}
}
