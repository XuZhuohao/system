package com.yui.system.wechat.officialaccounts.cache;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信缓存数据
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
public class WeChatCache {
    /**
     * 单例对象
     */
    private WeChatCache weChatCache;

    /**
     * 关闭创建入口
     */
    private WeChatCache() {
        if (SingletonHolder.instance != null) {
            throw new IllegalStateException();
        }
    }

    /**
     * 使用静态内部类处理单例模式
     */
    private static class SingletonHolder {
        private static WeChatCache instance = new WeChatCache();
    }

    public static WeChatCache getInstance() {
        return SingletonHolder.instance;
    }
    /**----------------------------------------------------*/
    @Setter
    @Getter
    private String accessToken;

}
