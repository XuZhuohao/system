package com.yui.system.library;

import com.yui.system.library.util.DateUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {
    private Long startTime;
    private static String startDate;
    @Before
    public void before(){
        System.out.println("测试开始==========================");
        this.startTime = System.currentTimeMillis();
    }
    @After
    public void after(){
        System.out.println("测试结束==========================");
        System.out.printf("耗费时长：%d\r\n", System.currentTimeMillis() - this.startTime);
    }
    @BeforeClass
    public static void beforeClass(){
        startDate = DateUtil.getDateStr(new Date(),"yyyy-MM-dd hh:mm:ss");
        System.out.println("class测试开始：====================================" + startDate);
    }

    @AfterClass
    public static void AfterClass(){
        System.out.println("class测试结束：====================================from "+ startDate +" to " + DateUtil.getDateStr(new Date(),"yyyy-MM-dd hh:mm:ss"));
    }
    @Test
    public void contextLoads() {
    }

}
