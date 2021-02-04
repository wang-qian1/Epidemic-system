package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Accessors(chain=true)
@Component
public class CitiesDaily {
	private String provinceName;
	private String cityName;
	private int currentConfirmedCount;
	private int curedCount;
	private int confirmedCount;
	private int suspectedCount;
	private int deadCount;
}
