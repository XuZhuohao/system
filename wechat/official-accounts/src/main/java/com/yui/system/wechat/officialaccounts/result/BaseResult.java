package com.yui.system.wechat.officialaccounts.result;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.mapping.Map;
import org.hibernate.mapping.PersistentClass;

import java.util.HashMap;

/**
 * 结果对象
 *
 * @author XuZhuohao
 * @date 2018/11/5
 */
@Setter
@Getter
public class BaseResult extends HashMap<String, Object> {
    public static final String YW_SUCCESS = "Y";
    public static final String YW_FAIL = "N";

    /**
     * 是否成功标志(程序)
     */
    private boolean isSuccess = true;
    /**
     * 是否成功标志(业务)
     */
    private String ywSuccess = YW_SUCCESS;
    /**
     * 错误信息
     */
    private String errMsg = "";
    /**
     * 结果代码
     */
    private int code = 1;

    /**
     * 获取结果
     * @return 结果对象
     */
    public BaseResult getResult(){
        this.put("isSuccess", isSuccess);
        this.put("errMsg", errMsg);
        this.put("code", code);
        this.put("ywSuccess", ywSuccess);
        return this;
    }
}
