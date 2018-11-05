package com.yui.system.wechat.officialaccounts.service;

import com.alibaba.fastjson.JSON;
import com.yui.system.wechat.officialaccounts.OfficialAccountsApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * weChatService测试
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
public class WeChatServiceTest extends OfficialAccountsApplicationTests {
    @Autowired
    private WeChatService weChatService;
    @Test
    public void getAccessToken(){
        System.out.println(JSON.toJSONString(weChatService.getAccessToken()));
    }
}
