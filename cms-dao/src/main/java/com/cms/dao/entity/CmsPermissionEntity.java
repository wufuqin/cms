package com.cms.dao.entity;

import com.cms.core.foundation.BaseEntity;

/**
 * 权限菜单实体类
 * @Author: 可乐
 * @Date: 22:43 2020/12/7
 */
@SuppressWarnings("all")
public class CmsPermissionEntity extends BaseEntity<Integer> {

    private Integer parentId;   // 父级id
    private Boolean menu;       // 是否菜单 0:否 1:是
    private String  icon;       // 菜单图标
    private String name;        // 权限名称
    private String action;      // 权限码
    private String url;         // 权限url
    private Integer priority;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getMenu() {
        return menu;
    }

    public void setMenu(Boolean menu) {
        this.menu = menu;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
