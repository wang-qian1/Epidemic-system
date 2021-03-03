package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.CitiesDaily;
import com.sanley.coronavirus.entity.DailyData;
import com.sanley.coronavirus.entity.ProvincesDaily;
import com.sanley.coronavirus.entity.Statistics;

import java.util.List;

public interface StatisticsService {
	public Statistics getStatistics(String position);
	public List<Statistics> getAllStatistics();
	public List<DailyData> getDailyByTime(int startTime,int endTime);
	public List<ProvincesDaily> getProvincesDailyByTime(String provinceCode, int startTime, int endTime);
	public CitiesDaily getCitiesDailyByCitiesName(String citiesName);
}
