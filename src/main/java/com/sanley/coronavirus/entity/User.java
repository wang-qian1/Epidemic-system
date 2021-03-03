package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/3/15.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.List;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private BigInteger phone;
    private String unit;

    public boolean isAdmin(){
        boolean flag=false;
        return flag;
    }
}
