package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/2/22.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Patient implements Serializable {
    private int baseId;
    private String infectionSource;
    private Date onsetDate;
    private String symptoms;
    private String hospital;
    private char critical;
    private String note;
    private Base base;
    private List<Inspect> inspects;


}
