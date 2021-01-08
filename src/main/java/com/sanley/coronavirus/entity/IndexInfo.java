package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/3/13.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class IndexInfo {
    private int currentPatientNumber;
    private int sumPatientNumber;
    private int deadNumber;
    private double deadRate;
    private int cureNumber;
    private double cureRate;
    private int sumTouchNumber;
    private int currentTouchNumber;
    private List dates;
    private List patientNums;
    private List cureNums;
    private String username;



}
