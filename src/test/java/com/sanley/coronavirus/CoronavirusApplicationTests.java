package com.sanley.coronavirus;
import com.sanley.coronavirus.dao.NewsDao;
import com.sanley.coronavirus.dao.StatisticsDao;
import com.sanley.coronavirus.dao.UserDao;
import com.sanley.coronavirus.entity.Statistics;
import com.sanley.coronavirus.entity.User;
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
    @Autowired
    private StatisticsDao statisticsDao;
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
//        utilCareler.Util();
//        String position = null;
//        int startTime = 20201210;
//        int endTime = 20201216;
//        System.out.println(statisticsDao.findProvincesDailyByTime(position,startTime,endTime));
//        System.out.println(newsDao.findGoodsGuides());
//        System.out.println(newsDao.findRecommends());
//        System.out.println(newsDao.findRemarks());
//        System.out.println(newsDao.findRumors());
//        System.out.println(newsDao.findTimelines());
        User user = new User();
        user.setPassword("admin");
        user.setUsername("admin");
        userDao.updateUser(user);
    }

}
