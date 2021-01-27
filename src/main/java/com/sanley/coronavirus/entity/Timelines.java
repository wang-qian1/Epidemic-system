package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Accessors(chain=true)
@Component
public class Timelines {
	private String sourceUrl;

	private int pubDate;

	private String title;

	private String summary;

	private String pubDateStr;

	private String infoSource;
}
