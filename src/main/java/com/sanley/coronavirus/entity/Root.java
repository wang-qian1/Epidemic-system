package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
@Component
public class Root {
	private Statistics globalStatistics;

	private Statistics domesticStatistics;

	private Statistics internationalStatistics;

	private List<Recommends> recommends ;

	private List<String> remarks ;

	private String createTime;

	private String generalRemark;

	private List<Rumors> rumors ;

	private List<GoodsGuides> goodsGuides ;

	private String modifyTime;

	private List<Timelines> timelines ;

	private List<Wikis> wikis ;

	private List<WHOArticle> WHOArticle;

	private List<String> notes ;
}
