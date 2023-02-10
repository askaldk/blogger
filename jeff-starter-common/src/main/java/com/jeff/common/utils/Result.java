package com.jeff.common.utils;

import com.jeff.common.base.BaseEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 前端返回 json 格式封裝類
 */
@Data
public class Result {
    /**
     * 返回狀態碼，處理成功 200，失敗 100
     */
    private int code;

    /**
     * 返回處理信息，成功或失敗
     */
    private String msg;

    /**
     * 成功返回 true，失敗返回 false
     */
    private Boolean success;

    /**
     * 返回給前端的數據
     */
    private Map<String, Object> extend= new HashMap<>();


    /**
     * 成功返回的 json 封裝體
     * @param value 原始數據
     * @return json 格式
     */
    public static Result successJson(Object value){
        Result result = new Result();
        result.setCode(BaseEnum.SUCCESS.getIndex());
        result.setMsg(BaseEnum.SUCCESS.getMsg());
        result.setSuccess(true);
        result.getExtend().put("data", value);
        return result;
    }

    /**
     * 失敗返回的 json 封裝體
     * @return json 格式
     */
    public static Result errorJson(){
        Result result = new Result();
        result.setCode(BaseEnum.FAIL.getIndex());
        result.setMsg(BaseEnum.FAIL.getMsg());
        result.setSuccess(false);
        return result;
    }

    /**
     * 失敗返回的 json 封裝體
     * @param msg
     * @return json 格式
     */
    public static Result errorJson(String msg){
        Result result = new Result();
        result.setCode(BaseEnum.FAIL.getIndex());
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    /**
     * 失敗返回的 json 封裝體
     * @param code
     * @param msg
     * @return json 格式
     */
    public static Result errorJson(String msg, Integer code){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

}
