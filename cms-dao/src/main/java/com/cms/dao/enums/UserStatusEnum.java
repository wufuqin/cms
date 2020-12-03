package com.cms.dao.enums;

import com.cms.core.foundation.BaseEnum;

/**
 * 用户状态枚举类
 * @Author: 可乐
 * @Date: 20:39 2020/12/1
 */
@SuppressWarnings("all")
public enum UserStatusEnum implements BaseEnum {

    NORMAL(1,"正常"),
    DISABLED(2,"禁用"),
    LOCKED(3,"锁定"),
    UNACTIVATED(4,"未激活");

    private int ordinal;
    private String label;

    UserStatusEnum(int ordinal, String label) {
        this.ordinal = ordinal;
        this.label = label;
    }

    /**
     * 获得标号
     *
     * @return
     */
    @Override
    public int getOrdinal() {
        return 0;
    }

    /**
     * 获取label
     *
     * @return
     */
    @Override
    public String getLabel() {
        return null;
    }
}























