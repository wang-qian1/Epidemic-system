package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/2/22.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Cure implements Serializable {
    private int baseId;
    private Date dischargeDate;
    private String current;
    private Base base;
    private Patient patient;
}
