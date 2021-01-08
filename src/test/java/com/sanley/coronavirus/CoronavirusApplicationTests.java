package com.sanley.coronavirus;

import com.sanley.coronavirus.dao.BaseDao;
import com.sanley.coronavirus.dao.PatientDao;
import com.sanley.coronavirus.entity.Base;
import com.sanley.coronavirus.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class CoronavirusApplicationTests {
    BaseDao dao;
    PatientDao da;
    @Test
    void contextLoads() {
        System.out.println("330321199809267326");
        System.out.println(da.findAll());
        Base byIdCard = dao.findByIdCard("330321199809267326");
        System.out.println(byIdCard);
    }

}
