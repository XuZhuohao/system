package com.yui.system.wechat.officialaccounts.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统配置
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "we-chat")
public class WeChatProperties {
    private String appId;
    private String appSecret;
    private String accessTokenUrlGet;
}
