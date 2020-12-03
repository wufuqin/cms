package com.cms.dao.entity;

import com.cms.core.foundation.BaseEntity;

/**
 * 日志表的实体类对象
 * @Author: 可乐
 * @Date: 20:43 2020/12/3
 */
@SuppressWarnings("all")
public class CmsLogEntity extends BaseEntity<Integer> {

    private Integer userId;    // 用户id
    private String username;   // 用户名称
    private String loginIp;    // ip地址
    private String url;        // URL地址
    private String content;    // 日志内容

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
