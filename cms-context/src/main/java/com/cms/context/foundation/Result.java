package com.cms.context.foundation;

import java.io.Serializable;

/**
 * 封装后端返回给前端的结果集
 *      封装了静态方法，直接调用，需要自己想要的信息时直接覆盖即可
 * @Author: 可乐
 * @Date: 9:52 2020/11/28
 */
@SuppressWarnings("all")
public class Result<T extends Serializable> implements Serializable {
    // 状态码
    private int restCode;

    // 出来结果信息
    private String restInfo;

    // 传递的数据
    private T data;

    public int getRestCode() {
        return restCode;
    }

    public void setRestCode(int restCode) {
        this.restCode = restCode;
    }

    public String getRestInfo() {
        return restInfo;
    }

    public void setRestInfo(String restInfo) {
        this.restInfo = restInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 只向前端返回状态码
     * @param restCode
     */
    public Result(int restCode) {
        this.restCode = restCode;
    }

    /**
     * 向前端返回状态码和出来结果信息
     * @param restCode
     * @param restInfo
     */
    public Result(int restCode, String restInfo) {
        this.restCode = restCode;
        this.restInfo = restInfo;
    }

    /**
     * 向前端返回状态码、处理信息、需要传递的数据
     * @param restCode
     * @param restInfo
     * @param data
     */
    public Result(int restCode, String restInfo, T data) {
        this.restCode = restCode;
        this.restInfo = restInfo;
        this.data = data;
    }

    /**
     * 向前端返回状态码、数据
     * @param restCode
     * @param data
     */
    public Result(int restCode, T data) {
        this.restCode = restCode;
        this.data = data;
    }

    /**
     * 向前端传递处理信息、数据
     * @param restInfo
     * @param data
     */
    public Result(String restInfo, T data) {
        this.restInfo = restInfo;
        this.data = data;
    }

    public static <W extends Serializable> Result<W> success() {
        return new Result<>(200, "成功");
    }

    public static <W extends Serializable> Result<W> success(W data) {
        return new Result<>(200, data);
    }

    public static <W extends Serializable> Result<W> success(String info) {
        return new Result<>(200, info);
    }

    public static <W extends Serializable> Result<W> success(String restInfo, W data) {
        return new Result<>(restInfo, data);
    }

    public static <W extends Serializable> Result<W> success(int code, String restInfo, W data) {
        return new Result<>(code, restInfo, data);
    }

    public static <W extends Serializable> Result<W> failed() {
        return new Result<>(500);
    }

    public static <W extends Serializable> Result<W> failed(String restInfo) {
        return new Result<>(500, restInfo);
    }

    public static <W extends Serializable> Result<W> failed(int code,String restInfo) {
        return new Result<>(code, restInfo);
    }

}














































