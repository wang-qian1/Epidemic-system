package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/2/22.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Message {
    private String dateId;
    private String username;
    private String healthCode;
    private String temperature1;
    private String temperature2;
    private String temperature;
    private String state;
    private String position;

}
