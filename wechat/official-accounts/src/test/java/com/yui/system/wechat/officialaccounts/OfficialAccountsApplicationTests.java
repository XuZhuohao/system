package com.yui.system.wechat.officialaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficialAccountsApplicationTests {
    @Before
    public void testBefore(){
        System.out.println("test begin ============================================");
    }
    @After
    public void testAfter(){
        System.out.println("test end ============================================");
    }
    @Test
    public void contextLoads() {
    }

}
