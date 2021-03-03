package com.sanley.coronavirus.controller;/*
Created by shkstart on 2020/2/23.
*/

import com.github.pagehelper.PageInfo;
import com.sanley.coronavirus.entity.*;
import com.sanley.coronavirus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientService service;
    @Autowired
    NewsService newsService;

    @Autowired
    BaseService baseService;

    //跳转确诊病人转化死亡页面
    @RequestMapping(value="/patient/toDead/{id}",method=RequestMethod.GET)
    public String toDead(Model model,@PathVariable("id")int id)
    {
        model.addAttribute("baseId",id);
        return "patientToDead";
    }
    //查看现存确诊病人
    @RequestMapping(value = "/patient/list",method = RequestMethod.GET)
    public String list(Model model,@RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){

        List<Patient> patients = service.findAll(page,size);
        PageInfo<User> pageInfo=new PageInfo(patients);
        model.addAttribute("pageInfo",pageInfo);;
        return "patientList";

    }


    //添加基础信息
    @RequestMapping(value="/patient/addBase",method=RequestMethod.POST)
    public String addBase(@RequestParam("name")String name,@RequestParam("idCard")String idCard,
                          @RequestParam("gender")char gender, @RequestParam("address")String address,
                          @RequestParam("age")int age,  @RequestParam("phone")String phone,
                          @RequestParam("msg")String msg,
                          Model model){
        Base base = new Base();
        System.out.println(gender);;
        base.setName(name).setAddress(address).setAge(age).setGender(gender).setIdCard(idCard).setPhone(new BigInteger(phone));
        baseService.add(base);
        Base b2= baseService.findByIdCard(idCard);
        int id = b2.getId();
        model.addAttribute("baseId",id);
        System.out.println(msg);
        if ("patient".equals(msg)){
            return "patientAdd2";
        }else{
            return "touchAdd2";
        }

    }


    //添加病患信息
    @RequestMapping(value="/patient/addPatient",method=RequestMethod.POST)
    public String addPatient(@RequestParam("baseId")int baseId, @RequestParam("infectionSource")String infectionSource,
                             @RequestParam("onsetDate") Date onsetDate, @RequestParam("symptoms")String symptoms,
                             @RequestParam("hospital")String hospital, @RequestParam("critical")char critical,
                             @RequestParam("note")String note){

        Patient patient=new Patient().setBaseId(baseId).setCritical(critical).setHospital(hospital)
                .setInfectionSource(infectionSource).setSymptoms(symptoms).setOnsetDate(onsetDate).setNote(note);
        service.add(patient);
        return "redirect:/patient/list";
    }

    //更新病人信息
    @RequestMapping(value="/patient/updatePatient",method=RequestMethod.POST)
    public String update(@RequestParam("baseId")int baseId, @RequestParam("infectionSource")String infectionSource,
                       @RequestParam("onsetDate") Date onsetDate, @RequestParam("symptoms")String symptoms,
                       @RequestParam("hospital")String hospital, @RequestParam("critical")char critical,
                       @RequestParam("note")String note)
    {     Patient patient=new Patient().setBaseId(baseId).setCritical(critical).setHospital(hospital)
            .setInfectionSource(infectionSource).setSymptoms(symptoms).setOnsetDate(onsetDate).setNote(note);
        service.update(patient);
        return "redirect:/patient/info/"+patient.getBaseId();

    }
    //跳转患者详情页面
    @RequestMapping(value="/patient/info/{id}",method=RequestMethod.GET)
    public String info(Model model,@PathVariable("id")int id)
    {
        Patient patient = service.findById(id);
        model.addAttribute("patient",patient);
        return "patientInfo";
    }
    //跳转患者编辑页面
    @RequestMapping(value="/patient/update/{id}",method=RequestMethod.GET)
    public String update(Model model,@PathVariable("id")int id)
    {
        Patient patient = service.findById(id);
        model.addAttribute("patient",patient);
        return "patientUpdate";
    }
    //跳转检测添加页面
    @RequestMapping(value="/patient/toAddTest/{id}",method=RequestMethod.GET)
    public String toTest(Model model,@PathVariable("id")int id)
    {
        model.addAttribute("baseId",id);
        return "patientAddTest";
    }

    //跳转添加页面
    @RequestMapping(value = "/patient/toAdd")
    public String toAdd(){
        return "patientAdd";
    }
}
