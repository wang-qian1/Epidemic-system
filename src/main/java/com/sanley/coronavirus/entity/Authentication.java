package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/3/16.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Authentication {
    private int id;
    private String description;
    private String name;
}
