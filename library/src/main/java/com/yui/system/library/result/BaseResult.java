package com.yui.system.library.result;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果
 *
 * @author XuZhuohao
 * @date 2018-12-01 16:05
 */
@Getter
public class BaseResult extends HashMap<String, Object> {
    private int code;
    private String msg;
    private boolean isSuccess;
    private Map<String, Object> date = new HashMap<>(16);
    {
        this.put("date", this.date);
        this.put("code", null);
        this.put("msg", "");
        this.put("isSuccess", null);
    }

    public BaseResult getSuccessResult(){
        this.setCode(1);
        this.setMsg("");
        this.setSuccess(true);
        return this;
    }
    public BaseResult getSuccessResult(String msg){
        this.setCode(1);
        this.setMsg(msg);
        this.setSuccess(true);
        return this;
    }
    public BaseResult getFailResult(String msg){
        this.setCode(-1);
        this.setMsg(msg);
        this.setSuccess(false);
        return this;
    }
    public BaseResult getFailResult(int code,String msg){
        this.setCode(code);
        this.setMsg(msg);
        this.setSuccess(false);
        return this;
    }

    public BaseResult setDate(String key, Object value){
        this.date.put(key, value);
        return this;
    }


    public BaseResult setDate(Map<String, Object> date) {
        this.date = date;
        this.put("date", this.date);
        return this;
    }

    public BaseResult setCode(int code) {
        this.code = code;
        this.put("code", this.code);
        return this;
    }

    public BaseResult setMsg(String msg) {
        this.msg = msg;
        this.put("msg", this.msg);
        return this;
    }

    public BaseResult setSuccess(boolean success) {
        this.isSuccess = success;
        this.put("isSuccess", this.isSuccess);
        return this;
    }
}
