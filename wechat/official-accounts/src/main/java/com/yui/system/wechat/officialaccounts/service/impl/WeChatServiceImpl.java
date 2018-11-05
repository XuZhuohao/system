package com.yui.system.wechat.officialaccounts.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yui.system.wechat.officialaccounts.config.WeChatProperties;
import com.yui.system.wechat.officialaccounts.result.WeChatResult;
import com.yui.system.wechat.officialaccounts.service.WeChatService;
import com.yui.system.wechat.officialaccounts.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信service实现类
 * @author XuZhuohao
 * @date 2018/11/5
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    @Autowired
    private WeChatProperties weChatProperties;

    @Override
    public WeChatResult getAccessToken() {
        WeChatResult result = new WeChatResult();
        try {
            Map<String, String> inMap = new HashMap<>(16);
            // https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
            inMap.put("grant_type", "client_credential");
            inMap.put("appid", weChatProperties.getAppId());
            inMap.put("secret", weChatProperties.getAppSecret());
            String responseJson = HttpUtil.doGet(weChatProperties.getAccessTokenUrlGet(), inMap);
            result.setResponseJson(responseJson);
            // 构建成json对象
            JSONObject jsonObject = JSON.parseObject(responseJson);
            // 把json结果全部放入result中
            jsonObject.forEach(result::put);
            // {"access_token":"ACCESS_TOKEN","expires_in":7200}
            if (result.get("access_token") == null) {
                // {"errcode":40013,"errmsg":"invalid appid"}
                result.setYwSuccess(WeChatResult.YW_FAIL);
                result.setErrMsg(String.valueOf(result.get("errmsg")));
            }
        } catch (Exception e){
            result.setSuccess(false);
            result.setErrMsg(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return result.getResult();
    }
}
