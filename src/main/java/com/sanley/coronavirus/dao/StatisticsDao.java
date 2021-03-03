package com.sanley.coronavirus.dao;

import com.sanley.coronavirus.entity.CitiesDaily;
import com.sanley.coronavirus.entity.DailyData;
import com.sanley.coronavirus.entity.ProvincesDaily;
import com.sanley.coronavirus.entity.Statistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Service
public interface StatisticsDao {

	@Select("select * from statistics")
	public List<Statistics> findAllStatistics();

	@Select("select * from statistics where position=#{position}")
	public Statistics findByPosition(String position);

	@Select("select * from daily where dateId between #{startTime} and #{endTime}")
	public List<DailyData> findDailyByTime(@Param("startTime") int startTime,@Param("endTime") int endTime);

	@Select({"<script>",
					"select * from provinces_daily",
					"where 1=1",
					"<when test='provinceCode!=null and provinceCode!= \"\"'>",
					"and provinceCode=#{provinceCode}",
					"</when>",
					" and dateId between #{startTime} and #{endTime}","</script>"})
	public List<ProvincesDaily> findProvincesDailyByTime(@Param("provinceCode") String provinceCode,@Param("startTime") int startTime,@Param("endTime") int endTime);

	@Select("select * from cities_daily where cityName=#{cityName}")
	public CitiesDaily findByCitiesName(String cityName);

	@Insert("insert into statistics(position,positionCode,confirmedCount,curedCount,deadCount,seriousCount,currentConfirmedCount,suspectedCount,currentConfirmedIncr,curedIncr,confirmedIncr,suspectedIncr,deadIncr) values(#{position},#{positionCode},#{confirmedCount},#{curedCount},#{deadCount},#{seriousCount},#{currentConfirmedCount},#{suspectedCount},#{currentConfirmedIncr},#{curedIncr},#{confirmedIncr},#{suspectedIncr},#{deadIncr})")
	public void add(Statistics statistics);

	@Insert("insert into daily values(#{dateId},#{countryName},#{countryCode},#{confirmedCount},#{curedCount},#{deadCount},#{seriousCount},#{currentConfirmedCount},#{suspectedCount},#{currentConfirmedIncr},#{curedIncr},#{confirmedIncr},#{suspectedIncr},#{deadIncr})")
	public void addDaily(DailyData dailyData);

	@Insert("insert into provinces_daily values(#{dateId},#{provinceCode},#{provinceName},#{confirmedCount},#{curedCount},#{deadCount},#{seriousCount},#{currentConfirmedCount},#{suspectedCount},#{currentConfirmedIncr},#{curedIncr},#{confirmedIncr},#{suspectedIncr},#{deadIncr})")
	public void addProvincesDaily(ProvincesDaily provincesDaily);

	@Insert("insert into cities_daily values(#{provinceName},#{cityName},#{confirmedCount},#{curedCount},#{deadCount},#{currentConfirmedCount},#{suspectedCount})")
	public void addCitiesDaily(CitiesDaily citiesDaily);

	@Update("update statistics set confirmedCount=#{confirmedCount},curedCount=#{curedCount},deadCount=#{deadCount},seriousCount=#{seriousCount},currentConfirmedCount=#{currentConfirmedCount},suspectedCount=#{suspectedCount},currentConfirmedIncr=#{currentConfirmedIncr},curedIncr=#{curedIncr},confirmedIncr=#{confirmedIncr},suspectedIncr=#{suspectedIncr},deadIncr=#{deadIncr}" +
					" where position=#{position}")
	public void update(Statistics statistics);

	@Delete("truncate table daily")
	public void runcateDaily();

	@Delete("truncate table provinces_daily")
	public void runcateProvincesDaily();

	@Delete("truncate table cities_daily")
	public void runcateCitiesDaily();
}
