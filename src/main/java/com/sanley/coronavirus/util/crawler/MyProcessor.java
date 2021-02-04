package com.sanley.coronavirus.util.crawler;

import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Data
@Component
public class MyProcessor implements PageProcessor {

	private String sel;

	/**
	定时执行,格式：秒分时日月星期
 */
	@Override
	public void process(Page page) {
		System.out.println(sel);
		switch (sel) {
			case "statistics" :
				page.putField("data",page.getJson());
				break;
			case "daily" :
				page.putField("daily",page.getJson());
				break;
			case "provincesDaily" :
				page.putField("provincesDaily",page.getJson());
				break;
			case "citiesDaily" :
				page.putField("citiesDaily",page.getJson());
				break;
			default:
				break;
		}
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
