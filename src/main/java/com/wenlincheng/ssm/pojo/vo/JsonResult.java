package com.wenlincheng.ssm.pojo.vo;

/**
 * @ClassName: JsonResult
 * @Description: 封装返回的json数据
 * @Author: Cheng
 * @Date: 2018/8/25 10:13
 * @Version: 1.0.0
 */
public class JsonResult<T> {
    // 返回的数据
    private T data;
    // 状态码
    private Integer code;
    // 返回的信息
    private String msg;
    // 目标总数
    private Integer count;

    /**
     * 若没有数据返回，默认状态码为200，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = 200;
        this.msg = "操作成功！";
        this.count = 0;
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     * @param count
     */
    public JsonResult(Integer code, String msg, Integer count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = 0;
        this.msg = msg;
        this.count = 0;
    }

    /**
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     * @param data
     * @param count
     */
    public JsonResult(T data, Integer count) {
        this.data = data;
        this.code = 0;
        this.msg = "操作成功！";
        this.count = count;
    }

    /**
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = 0;
        this.msg = "操作成功！";
        this.count = 0;
    }

    /**
     * 返回状态码、提示信息！
     * @param code
     * @param msg
     */
    public JsonResult(Integer code, String msg){
        this.data = null;
        this.count = 0;
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回，状态码为0，人为指定提示信息
     * @param data
     * @param msg
     * @param count
     */
    public JsonResult(T data, String msg, Integer count) {
        this.data = data;
        this.code = 0;
        this.msg = msg;
        this.count =count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
