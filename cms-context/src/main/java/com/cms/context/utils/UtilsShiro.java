package com.cms.context.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 通过shiro再封装的工具类
 * @Author: 可乐
 * @Date: 14:38 2020/11/28
 */
@SuppressWarnings("all")
public class UtilsShiro {

    /**
     * 通过shiro获取session
     * @return
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 通过shiro获取session
     * @return
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }
}
























