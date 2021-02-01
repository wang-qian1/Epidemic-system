package com.sanley.coronavirus.util.crawler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class MyProcessor implements PageProcessor {

	/**
	定时执行,格式：秒分时日月星期
 */
	@Override
	public void process(Page page) {
		page.putField("data",page.getJson());
	}

	@Override
	public Site getSite() {
		/**
			爬虫配置信息设置
		 */
		return Site.me()
						.setCharset("utf-8")    //设置编码
						.setSleepTime(1)        //设置抓取间隔
						.setTimeOut(3000)         //设置超时时间
						.setRetrySleepTime(3000)      //设置重试时间
						.setRetryTimes(3);       //设置重试次数
	}
}
