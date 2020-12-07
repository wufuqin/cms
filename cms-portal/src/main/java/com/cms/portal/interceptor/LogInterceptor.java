package com.cms.portal.interceptor;

import com.cms.context.utils.UtilsHttp;
import com.cms.context.utils.UtilsShiro;
import com.cms.core.annotation.DoLog;
import com.cms.service.api.CmsLogService;
import com.cms.service.dto.CmsLogDto;
import com.cms.service.dto.CmsUserDto;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 日志拦截器
 *
 * @Author: 可乐
 * @Date: 20:40 2020/12/7
 */
@SuppressWarnings("all")
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CmsLogService cmsLogService;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 记录日志
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 获取方法类型
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取方法上的注解
        DoLog doLog = handlerMethod.getMethodAnnotation(DoLog.class);
        // 判断获取的注解如果存在
        Optional.ofNullable(doLog).ifPresent(x -> {
            // 获取url
            String url = request.getRequestURI();
            // 获取用户ip
            String ip = UtilsHttp.getRemoteAddress();
            // 获取注解中的content属性
            String content = doLog.content();
            // 使用多线程方式，将日志异步写入
            threadPoolTaskExecutor.execute(() -> {
                // 获取subject：当前用户
                Subject subject = UtilsShiro.getSubject();
                // 获取用户信息
                CmsUserDto cmsUserDto = (CmsUserDto) subject.getPrincipal();
                // 将日志保存
                cmsLogService.save(CmsLogDto.of(cmsUserDto.getId(), cmsUserDto.getUsername(), ip, url, content));
            });
        });
        super.postHandle(request, response, handler, modelAndView);
    }

}
