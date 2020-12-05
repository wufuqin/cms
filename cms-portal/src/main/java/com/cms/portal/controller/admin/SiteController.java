package com.cms.portal.controller.admin;

import com.cms.context.utils.UtilsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 站点配置控制器
 * @Author: 可乐
 * @Date: 20:13 2020/12/5
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("site")
public class SiteController {

    /**
     * 去到站点配置首页
     * @return
     */
    @GetMapping("index.do")
    public String toIndex(){
        return UtilsTemplate.adminTemplate("site","index");
    }
}
















