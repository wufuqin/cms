package com.cms.portal.security.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * authc登录认证拦截器
 * @Author: 可乐
 * @Date: 16:45 2020/11/22
 */
@SuppressWarnings("all")
public class CmsAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 判断用户的登录请求，将其重定向到登录页面
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(), request) || this.pathsMatch("/admin/cms/login.do", request) ;
    }
}
