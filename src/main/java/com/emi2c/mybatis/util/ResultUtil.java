package com.emi2c.mybatis.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果工具类
 */
public class ResultUtil {

    private ResultUtil() {}

    private static String SUCCESS = "success";
    private static String FAILURE = "failure";

    private static int OK = 200;
    private static int NOT_FOUND = 404;
    private static int UN_AUTHORIZED = 403;
    private static int SERVER_ERROR = 500;


    /**
     * 获取成功响应
     * @return
     */
    public static Map<String, Object> getSuccess() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", OK);
        result.put("success", true);
        result.put("message", SUCCESS);
        return result;
    }

    /**
     * 获取成功响应
     * @param code    返回编码
     * @param message 返回消息
     * @return
     */
    public static Map<String, Object> getSuccess(int code, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("success", true);
        result.put("message", message);
        return result;
    }

    /**
     * 获取成功响应
     * @param code    返回编码
     * @param message 返回消息
     * @param data    返回数据
     * @return
     */
    public static Map<String, Object> getSuccess(int code, String message, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("success", true);
        result.put("message", message);
        result.put("data", data);
        return result;
    }

    /**
     * 获取成功响应
     * @param code      返回编码
     * @param message   返回消息
     * @param data      返回数据
     * @param pageIndex 分页页码
     * @param pageSize  分页显示条数
     * @return
     */
    public static Map<String, Object> getSuccess(int code, String message, Object data, int pageIndex, int pageSize) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("success", true);
        result.put("message", message);
        result.put("data", data);
        result.put("pageIndex", pageIndex);
        result.put("pageSize", pageSize);
        return result;
    }


    /**
     * 获取失败响应
     * @return
     */
    public static Map<String, Object> getFailure() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", SERVER_ERROR);
        result.put("success", false);
        result.put("message", FAILURE);
        return result;
    }


    /**
     * 获取失败响应
     * @param code    返回编码
     * @param message 返回消息
     * @return
     */
    public static Map<String, Object> getFailure(int code, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("success", false);
        result.put("message", message);
        return result;
    }

}
