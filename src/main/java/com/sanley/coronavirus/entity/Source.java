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
public class Source implements Serializable {
    private int id;
    private String name;
    private String type;
    private int number;
    private int hospitalId;

}
