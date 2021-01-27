package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Accessors(chain=true)
@Component
public class Remarks {
	private String title;
	private String content;
}
