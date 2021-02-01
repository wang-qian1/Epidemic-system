package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Accessors(chain=true)
@Component
public class Recommends {
	private int contentType;

	private int countryType;

	private String title;

	private int recordStatus;

	private String linkUrl;

	private String imgUrl;

	private String description;
}
