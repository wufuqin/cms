package com.cms.portal.security.filter;

import org.apache.shiro.web.filter.authc.UserFilter;

/**
 * 自定义user用户已登录拦截器
 * @Author: 可乐
 * @Date: 16:47 2020/11/22
 */
@SuppressWarnings("all")
public class CmsUserFilter extends UserFilter {

    // 登录地址
    private String adminLoginUrl;
    //
    private String adminPrefix;

    public String getAdminLoginUrl() {
        return adminLoginUrl;
    }

    public void setAdminLoginUrl(String adminLoginUrl) {
        this.adminLoginUrl = adminLoginUrl;
    }

    public String getAdminPrefix() {
        return adminPrefix;
    }

    public void setAdminPrefix(String adminPrefix) {
        this.adminPrefix = adminPrefix;
    }
}
