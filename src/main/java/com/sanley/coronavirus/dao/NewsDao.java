package com.sanley.coronavirus.dao;
import com.sanley.coronavirus.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface NewsDao {
	@Insert("insert into remarks(title,content) values(#{title},#{content})")
	public void addRemarks(Remarks remarks);
	@Insert("insert into goodsGuides values(#{contentImgUrls},#{recordStatus},#{categoryName},#{title})")
	public void addGoodsGuides(GoodsGuides goodsGuides);
	@Insert("insert into rumors(title,body,mainSummary,sourceUrl,summary,score,rumorType) values(#{title},#{body},#{mainSummary},#{sourceUrl},#{summary},#{score},#{rumorType})")
	public void addRumors(Rumors rumors);
	@Insert("insert into recommends(contentType,countryType,title,recordStatus,linkUrl,imgUrl,description) values(#{contentType},#{countryType},#{title},#{recordStatus},#{linkUrl},#{imgUrl},#{description})")
	public void addRecommends(Recommends recommends);
	@Insert("insert into timelines(sourceUrl,title,summary,pubDateStr,infoSource) values(#{sourceUrl},#{title},#{summary},#{pubDateStr},#{infoSource})")
	public void addTimelines(Timelines timelines);
	@Delete("truncate table remarks")
	public void runcateRemarks();
	@Delete("truncate table rumors")
	public void runcateRumors();
	@Delete("truncate table goodsGuides")
	public void runcateGoodsGuides();
	@Delete("truncate table recommends")
	public void runcateRecommends();
	@Delete("truncate table timelines")
	public void runcateTimelines();
}
