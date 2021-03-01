package com.sanley.coronavirus;
import com.sanley.coronavirus.util.crawler.SpiderTask;
import com.sanley.coronavirus.util.crawler.UtilCareler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoronavirusApplicationTests {
    @Autowired
    private UtilCareler utilCareler;
    @Test
    public void contextLoads() {
//        utilCareler.Util();
    }

}
