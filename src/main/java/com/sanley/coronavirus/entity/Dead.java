package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/2/22.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dead implements Serializable {
    private int baseId;
    @DateTimeFormat(pattern="YYYY-MM-dd")
    private Date deadTime;
    private Base base;
    private Patient patient;
}
