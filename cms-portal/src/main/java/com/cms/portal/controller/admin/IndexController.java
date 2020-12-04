package com.cms.portal.controller.admin;

import com.cms.context.utils.UtilsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 后台首页控制器
 * @Author: 可乐
 * @Date: 21:13 2020/12/4
 */
@SuppressWarnings("all")
@Controller
public class IndexController {

    /**
     * 登录成功之后跳转到后台首页
     * @return
     */
    @GetMapping("index.do")
    public String toIndex(){
        return UtilsTemplate.adminTemplate("index");
    }


}
