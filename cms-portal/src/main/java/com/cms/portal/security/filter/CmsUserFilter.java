package com.cms.portal.security.filter;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义user用户已登录拦截器
 *
 * @Author: 可乐
 * @Date: 16:47 2020/11/22
 */
@SuppressWarnings("all")
public class CmsUserFilter extends UserFilter {

    private String adminLoginUrl;
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

    /**
     * 请求失败后跳转到登录页面
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest req, ServletResponse response) throws Exception {
        // 将请求转换为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        // 保存该请求
        this.saveRequest(request);
        // 获取请求的URI
        String requestURI = request.getRequestURI();
        // 根据请求的URI判断请求是前台还是后台路径，然后跳转到对应的登录页面
        WebUtils.issueRedirect(request, response, (requestURI.startsWith(adminPrefix)) ? adminLoginUrl : this.getLoginUrl());
        return false;
    }
}



















