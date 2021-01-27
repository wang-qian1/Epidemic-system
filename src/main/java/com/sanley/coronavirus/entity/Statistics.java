package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Accessors(chain=true)
@Component
public class Statistics {
	private String position;
	private int currentConfirmedCount;
	private int curedCount;
	private int confirmedCount;
	private int seriousCount;
	private int suspectedCount;
	private int deadCount;
	private int currentConfirmedIncr;
	private int curedIncr;
	private int confirmedIncr;
	private int suspectedIncr;
	private int deadIncr;
}
