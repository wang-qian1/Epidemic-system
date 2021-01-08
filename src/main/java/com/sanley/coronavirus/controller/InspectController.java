package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/2/24.
*/

import com.sanley.coronavirus.entity.Hospital;
import com.sanley.coronavirus.entity.Inspect;
import com.sanley.coronavirus.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class InspectController {
    @Autowired
    InspectService service;

    @RequestMapping(value = "/inspect/get/{id}",method = RequestMethod.GET)
    public List<Inspect> get(@PathVariable("id")int id){

        return service.find(id);
    }

    @RequestMapping(value="/inspect/add",method=RequestMethod.POST)
    public void add(@RequestBody Inspect Inspect)
    {
         service.add(Inspect);
    }

}
