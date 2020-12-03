package com.cms.core.foundation;

/**
 * 枚举规范接口
 * @Author: 可乐
 * @Date: 20:48 2020/12/1
 */
@SuppressWarnings("all")
public interface BaseEnum {
    /**
     * 获得标号
     * @return
     */
    int getOrdinal();

    /**
     * 获取label
     * @return
     */
    String getLabel();
}
