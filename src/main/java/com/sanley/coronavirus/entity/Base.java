package com.sanley.coronavirus.entity;/*
Created by shkstart on 2020/2/22.
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Base implements Serializable {
    private int id;
    private String idCard;
    private String name;
    private int age;
    private char gender;
    private String address;
    private BigInteger phone;

}
