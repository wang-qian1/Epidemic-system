package com.sanley.coronavirus.util.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.RedisScheduler;

@EnableScheduling
@Controller
public class SpiderTask {

	public void startSpider(String Url,PageProcessor pageProcessor,Pipeline pipeline) {
		Spider.create(pageProcessor)
						.addUrl(Url)
						//Scheduler过滤器,使用redis过滤器
						.setScheduler(new QueueScheduler()
										.setDuplicateRemover(new BloomFilterDuplicateRemover(10000000))) //参数设置需要对多少条数据去重
						.addPipeline(new JsonFilePipeline())        //设置结果 以Json格式输出
						.addPipeline(pipeline)        //设置结果 以Json格式输出
						.thread(3)//开三个线程，根据需求设置
						.run();
	}
}
