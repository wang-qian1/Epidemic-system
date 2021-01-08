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
public class Manage implements Serializable {
    private String id;
    private String password;
    private String name;
    private int phone;
    private String unit;
    private String permission;

}
