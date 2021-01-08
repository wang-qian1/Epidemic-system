package com.sanley.coronavirus.service;/*
Created by shkstart on 2020/2/23.
*/

import com.sanley.coronavirus.entity.Inspect;

import java.util.List;

public interface InspectService {
    public List<Inspect> find(int baseId);
    public void add(Inspect inspect);
}
