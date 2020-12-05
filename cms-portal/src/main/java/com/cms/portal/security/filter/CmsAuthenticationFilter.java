package com.cms.portal.security.filter;

import com.alibaba.fastjson.JSON;
import com.cms.context.constant.ConstantsPool;
import com.cms.context.foundation.Result;
import com.cms.context.utils.UtilsHttp;
import com.cms.context.utils.UtilsShiro;
import com.cms.service.api.CmsLogService;
import com.cms.service.api.CmsUserService;
import com.cms.service.api.CommonService;
import com.cms.service.dto.CmsLogDto;
import com.cms.service.dto.CmsUserDto;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 处理登录
 *      authc登录认证拦截器
 *
 * @Author: 可乐
 * @Date: 16:45 2020/11/22
 */
@SuppressWarnings("all")
public class CmsAuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    private CommonService commonService;

    @Autowired
    private CmsUserService cmsUserService;

    @Autowired
    private CmsLogService cmsLogService;


    // 注入线程池对象
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 判断用户的登录请求，将其重定向到登录页面
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(), request) || this.pathsMatch("/admin/cms/login.do", request);
    }

    /**
     * 重写shiro中的处理登录的方法
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

        // 设置响应字符类型
        response.setCharacterEncoding("utf-8");
        // 设置响应头的类型及格式
        response.setContentType("application/json;charset=UTF-8");
        // 验证码校验
        String captcha = commonService.verifyImageCaptcha(WebUtils.getCleanParam(request, "captcha"));
        PrintWriter writer = response.getWriter();
        // 将信息响应回页面
        //TODO 跳过校验验证码
        if(1>2 && Objects.nonNull(captcha)){
            writer.write(JSON.toJSONString(Result.failed(captcha)));
            writer.close();
            return false;
        }

        // 获取subject
        Subject subject = UtilsShiro.getSubject();
        AuthenticationToken token = this.createToken(request, response);
        try{
            subject.login(token);
            // 记录登录日志
            onLoginSuccess(token,subject,request,response);
            writer.write(JSON.toJSONString(Result.success("登录成功")));
        }catch(UnknownAccountException | IncorrectCredentialsException e){
            writer.write(JSON.toJSONString(Result.failed("用户名或密码错误,请重新输入!")));
        }catch (DisabledAccountException e){
            writer.write(JSON.toJSONString(Result.failed(e.getMessage())));
        }catch (Exception e){
            //用户有可能已经登录 其他错误
            //用户有可能已经登录 其他错误
            writer.write(JSON.toJSONString((subject.isAuthenticated()?Result.success("登录成功"):Result.failed(ConstantsPool.EXCEPTION_NETWORK_ERROR))));
        }
        writer.close();
        // 返回false是不需要自动跳转页面，跳转到前端指定的页面
        return false;
    }

    /**
     * 重写shiro中的onLoginSuccess，记录日志
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        // 获取当前登录用户的IP地址
        String ip = UtilsHttp.getRemoteAddress();
        // 获取用户的请求路径
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        // 使用多线程的方式异步写入登录日志
        threadPoolTaskExecutor.execute(()->{
            // 获取当前用户的信息
            CmsUserDto cmsUserDto = (CmsUserDto) subject.getPrincipal();
            // 获取sessionId
            cmsUserDto.setSessionId(UtilsShiro.getSession().getId().toString());
            // 更新用户副表中的数据
            cmsUserService.update(cmsUserDto);
            // 将数据保存到日志表中
            cmsLogService.save(CmsLogDto.of(cmsUserDto.getId(),cmsUserDto.getUsername(),ip,url,"用户后台系统登录"));
        });
        return false;
    }
}
























