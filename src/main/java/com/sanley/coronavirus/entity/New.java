package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Accessors(chain=true)
@Component
public class New {
	private String title;
	private String content;
	private String mainSummary;
	private String sourceUrl;
	private String summary;
	private int score;
	private int rumorType;
}
