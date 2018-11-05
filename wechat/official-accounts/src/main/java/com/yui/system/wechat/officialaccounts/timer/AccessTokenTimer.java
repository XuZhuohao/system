package com.yui.system.wechat.officialaccounts.timer;

import com.yui.system.wechat.officialaccounts.cache.WeChatCache;
import com.yui.system.wechat.officialaccounts.result.WeChatResult;
import com.yui.system.wechat.officialaccounts.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时获取access_token
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
public class AccessTokenTimer {
    @Autowired
    private WeChatService weChatService;

    @Scheduled(cron = "0 0 0/2 * * ? ")
    public void accessTokenTimer() {
        // 失败次数
        int failTimes = 0;
        while (!updateAccessToken()) {
            try {
                failTimes ++;
                // 失败时暂停5秒重新获取
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (failTimes > 10) {
                // TODO: 发送邮件通知管理员
                break;
            }
        }
    }

    private boolean updateAccessToken() {
        WeChatCache weChatCache = WeChatCache.getInstance();
        WeChatResult accessResult = weChatService.getAccessToken();
        if (accessResult.isSuccess() && WeChatResult.YW_SUCCESS.equals(accessResult.getYwSuccess())) {
            weChatCache.setAccessToken(String.valueOf(accessResult.get("access_token")));
            return true;
        } else {
            // TODO:日志
            return false;
        }
    }

}
