package com.yui.system.library.param;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author XuZhuohao
 * @date 2018-12-01 16:53
 */
@Getter
@Component
@Configuration
public class SystemParam {
    @Value("${book.get.url}")
    private String doubanUrl;
}
