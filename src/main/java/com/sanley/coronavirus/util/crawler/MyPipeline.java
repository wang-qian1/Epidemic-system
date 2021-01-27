package com.sanley.coronavirus.util.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sanley.coronavirus.dao.StatisticsDao;
import com.sanley.coronavirus.entity.Root;
import com.sanley.coronavirus.entity.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

@Component
public class MyPipeline implements us.codecraft.webmagic.pipeline.Pipeline {
	@Autowired
	private StatisticsDao statisticsDao;
	@Autowired
	private Root root;
	@Autowired
	private Statistics statistics;
	@Override
	public void process(ResultItems resultItems, Task task) {
		root = JSON.parseObject(resultItems.get("data").toString(), new TypeReference<Root>(){});
		statistics = root.getGlobalStatistics();
		statistics.setPosition("GlobalStatistics");
		if (statisticsDao.find(statistics.getPosition())!= null){
			statisticsDao.update(statistics);
		} else {
			statisticsDao.add(statistics);
		}
		System.out.println("end--------------->");
	}
}
