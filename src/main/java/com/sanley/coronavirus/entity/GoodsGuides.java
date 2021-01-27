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
public class GoodsGuides {
	private List<String> contentImgUrls ;

	private int recordStatus;

	private String categoryName;

	private String title;

}
