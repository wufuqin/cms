package com.cms.dao.entity;

import com.cms.core.foundation.BaseEntity;

import java.io.Serializable;

/**
 * 副表的用户实体类
 * @Author: 可乐
 * @Date: 9:53 2020/11/29
 */
@SuppressWarnings("all")
public class CmsUserEntity extends BaseEntity<Integer> {
    private String username;             // 用户名
    private Integer status;              // 状态
    private Boolean admin;               // 是否为后台管理
    private String lastLoginIp;          // 用户的IP
    private Serializable sessionId;      // 用户的sessionId
    /**
     * 超级管理员
     */
    private Boolean administrator;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Serializable getSessionId() {
        return sessionId;
    }

    public void setSessionId(Serializable sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }
}
