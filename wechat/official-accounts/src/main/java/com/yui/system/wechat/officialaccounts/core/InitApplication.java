package com.yui.system.wechat.officialaccounts.core;

import com.yui.system.wechat.officialaccounts.timer.AccessTokenTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
@Component
public class InitApplication implements ApplicationRunner {
    @Autowired
    private AccessTokenTimer accessTokenTimer;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        accessTokenTimer.accessToken();
    }
}
