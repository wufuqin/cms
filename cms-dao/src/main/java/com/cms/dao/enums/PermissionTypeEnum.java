package com.cms.dao.enums;

import com.cms.core.foundation.BaseEnum;

/**
 * 权限枚举类
 * @Author: 可乐
 * @Date: 21:02 2020/12/11
 */
@SuppressWarnings("all")
public enum PermissionTypeEnum implements BaseEnum {
    BUTTON(0,"按钮"),
    MENU(1,"菜单");

    private int ordinal;
    private String label;

    PermissionTypeEnum(int ordinal, String label) {
        this.ordinal = ordinal;
        this.label = label;
    }

    @Override
    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
