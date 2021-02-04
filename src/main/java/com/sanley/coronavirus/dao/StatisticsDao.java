package com.sanley.coronavirus.dao;

import com.sanley.coronavirus.entity.CitiesDaily;
import com.sanley.coronavirus.entity.DailyData;
import com.sanley.coronavirus.entity.ProvincesDaily;
import com.sanley.coronavirus.entity.Statistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
@Mapper
@Service
public interface StatisticsDao {
	@Insert("insert into statistics(position,positionCode,confirmedCount,curedCount,deadCount,seriousCount,currentConfirmedCount,suspectedCount,currentConfirmedIncr,curedIncr,confirmedIncr,suspectedIncr,deadIncr) values(#{position},#{positionCode},#{confirmedCount},#{curedCount},#{deadCount},#{seriousCount},#{currentConfirmedCount},#{suspectedCount},#{currentConfirmedIncr},#{curedIncr},#{confirmedIncr},#{suspectedIncr},#{deadIncr})")
	public void add(Statistics statistics);

	@Insert("insert into daily values(#{countryName},#{countryCode},#{confirmedCount},#{curedCount},#{deadCount},#{seriousCount},#{currentConfirmedCount},#{suspectedCount},#{currentConfirmedIncr},#{curedIncr},#{confirmedIncr},#{suspectedIncr},#{deadIncr})")
	public void addDaily(DailyData dailyData);

	@Insert("insert into provinces_daily values(#{dateId},#{provinceCode},#{provinceName},#{confirmedCount},#{curedCount},#{deadCount},#{seriousCount},#{currentConfirmedCount},#{suspectedCount},#{currentConfirmedIncr},#{curedIncr},#{confirmedIncr},#{suspectedIncr},#{deadIncr})")
	public void addProvincesDaily(ProvincesDaily provincesDaily);

	@Insert("insert into cities_daily values(#{provinceName},#{cityName},#{confirmedCount},#{curedCount},#{deadCount},#{currentConfirmedCount},#{suspectedCount})")
	public void addCitiesDaily(CitiesDaily citiesDaily);

	@Update("update statistics set confirmedCount=#{confirmedCount},curedCount=#{curedCount},deadCount=#{deadCount},seriousCount=#{seriousCount},currentConfirmedCount=#{currentConfirmedCount},suspectedCount=#{suspectedCount},currentConfirmedIncr=#{currentConfirmedIncr},curedIncr=#{curedIncr},confirmedIncr=#{confirmedIncr},suspectedIncr=#{suspectedIncr},deadIncr=#{deadIncr}" +
					" where position=#{position}")
	public void update(Statistics statistics);

	@Select("select * from statistics where positionCode=#{positionCode}")
	public Statistics find(String positionCode);

	@Delete("truncate table daily")
	public void runcateDaily();

	@Delete("truncate table provinces_daily")
	public void runcateProvincesDaily();

	@Delete("truncate table cities_daily")
	public void runcateCitiesDaily();
}
