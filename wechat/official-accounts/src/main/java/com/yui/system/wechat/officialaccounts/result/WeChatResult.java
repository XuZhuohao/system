package com.yui.system.wechat.officialaccounts.result;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信返回结果
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
@Setter
@Getter
public class WeChatResult extends BaseResult {
    private String responseJson;

    @Override
    public WeChatResult getResult(){
        super.getResult();
        this.put("responseJson", responseJson);
        return this;
    }
}
