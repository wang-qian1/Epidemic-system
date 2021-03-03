package com.sanley.coronavirus.service.iml;

import com.sanley.coronavirus.dao.StatisticsDao;
import com.sanley.coronavirus.entity.CitiesDaily;
import com.sanley.coronavirus.entity.DailyData;
import com.sanley.coronavirus.entity.ProvincesDaily;
import com.sanley.coronavirus.entity.Statistics;
import com.sanley.coronavirus.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImp implements StatisticsService {
	@Autowired
	private StatisticsDao statisticsDao;
	@Override
	public Statistics getStatistics(String position) {
		return statisticsDao.findByPosition(position);
	}

	@Override
	public List<Statistics> getAllStatistics() {
		return statisticsDao.findAllStatistics();
	}

	@Override
	public List<DailyData> getDailyByTime(int startTime, int endTime) {
		return statisticsDao.findDailyByTime(startTime,endTime);
	}

	@Override
	public CitiesDaily getCitiesDailyByCitiesName(String citiesName) {
		return statisticsDao.findByCitiesName(citiesName);
	}

	@Override
	public List<ProvincesDaily> getProvincesDailyByTime(String provinceCode, int startTime, int endTime) {
		return statisticsDao.findProvincesDailyByTime(provinceCode,startTime,endTime);
	}

}
