package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/2/22.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Touch implements Serializable {
    private int baseId;
    private String comeFrom;
    private String isoAddress;
    private Date startDate;
    private char finished;
    private Base base;

}
