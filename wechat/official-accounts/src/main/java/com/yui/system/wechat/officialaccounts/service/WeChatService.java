package com.yui.system.wechat.officialaccounts.service;

import com.yui.system.wechat.officialaccounts.result.WeChatResult;

import java.util.Map;

/**
 * 微信服务
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
public interface WeChatService {
    /**
     * 获取 access_token
     * @return 封装结果集
     */
    WeChatResult getAccessToken();
}
