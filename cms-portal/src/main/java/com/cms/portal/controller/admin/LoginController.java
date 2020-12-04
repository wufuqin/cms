package com.cms.portal.controller.admin;

import com.cms.context.utils.UtilsShiro;
import com.cms.context.utils.UtilsTemplate;
import com.cms.service.api.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 后台登录控制器
 *
 * @Author: 可乐
 * @Date: 15:15 2020/11/21
 */
@SuppressWarnings("all")
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private CommonService commonService;

    /**
     * 去到后台登录页面
     *
     * @return
     */
    @GetMapping("login.do")
    public String toLogin() {
        Subject subject = UtilsShiro.getSubject();
        if(subject.isAuthenticated()){
            // 重定向，避免重复登录
            return "redirect:index.do";
        }
        return UtilsTemplate.adminTemplate("login");
    }

    /**
     * 生成验证码
     */
    @GetMapping("captcha.do")
    public void doCaptcha(HttpServletResponse httpServletResponse) {
       // 调用公共接口中的生成验证码方法生成验证码
       commonService.imageCaptcha();

    }


}



















