package com.cms.core.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *      拦截器统一添加日志
 * @Author: 可乐
 * @Date: 20:34 2020/12/7
 */
@SuppressWarnings("all")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DoLog {

    /**
     * 日志的内容
     * @return
     */
    public String content();
}
