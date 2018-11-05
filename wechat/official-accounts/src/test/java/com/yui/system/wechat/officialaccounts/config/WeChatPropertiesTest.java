package com.yui.system.wechat.officialaccounts.config;

import com.alibaba.fastjson.JSON;
import com.yui.system.wechat.officialaccounts.OfficialAccountsApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 微信配置文件测试
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
public class WeChatPropertiesTest extends OfficialAccountsApplicationTests {
    @Autowired
    private WeChatProperties weChatProperties;

    @Test
    public void getProperties(){
        System.out.println(JSON.toJSONString(weChatProperties));

    }
}
