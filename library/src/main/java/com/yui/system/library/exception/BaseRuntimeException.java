package com.yui.system.library.exception;

import com.yui.system.library.result.BaseResult;
import lombok.Getter;
import lombok.Setter;

/**
 * 基础运行时异常
 *
 * @author XuZhuohao
 * @date 2018-12-01 23:30
 */
@Setter
@Getter
public class BaseRuntimeException extends RuntimeException {
    private BaseResult baseResult;

    public BaseRuntimeException(BaseResult baseResult){
        super();
        this.baseResult = baseResult;
    }
}
