package com.cms.service.dto;

import com.cms.core.foundation.BaseDto;
import com.cms.dao.enums.UserStatusEnum;

/**
 * 用户副表的dto类
 *      封装需要转换的字段
 * @Author: 可乐
 * @Date: 9:38 2020/11/29
 */
@SuppressWarnings("all")
public class CmsUserDto extends BaseDto<Integer> {

    private String username;            // 用户名
    private UserStatusEnum status;      // 状态
    private Boolean admin;              // 是否为后台管理
    private String lastLoginIp;         // 用户的IP
    private String sessionId;     // 用户的sessionId
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

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }
}






















