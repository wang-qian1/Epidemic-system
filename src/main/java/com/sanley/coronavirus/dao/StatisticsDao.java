package com.sanley.coronavirus.dao;

import com.sanley.coronavirus.entity.Statistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
@Mapper
@Service
public interface StatisticsDao {
	@Insert("insert into statistics(position,confirmedCount,curedCount,deadCount,seriousCount,currentConfirmedCount,suspectedCount,currentConfirmedIncr,curedIncr,confirmedIncr,suspectedIncr,deadIncr) values(#{position},#{confirmedCount},#{curedCount},#{deadCount},#{seriousCount},#{currentConfirmedCount},#{suspectedCount},#{currentConfirmedIncr},#{curedIncr},#{confirmedIncr},#{suspectedIncr},#{deadIncr})")
	public void add(Statistics statistics);

	@Update("update statistics set confirmedCount=#{confirmedCount},curedCount=#{curedCount},deadCount=#{deadCount},seriousCount=#{seriousCount},currentConfirmedCount=#{currentConfirmedCount},suspectedCount=#{suspectedCount},currentConfirmedIncr=#{currentConfirmedIncr},curedIncr=#{curedIncr},confirmedIncr=#{confirmedIncr},suspectedIncr=#{suspectedIncr},deadIncr=#{deadIncr}" +
					"where position=#{position}")
	public void update(Statistics statistics);

	@Select("select * from statistics position=#{position}")
	public Statistics find(String position);

}
