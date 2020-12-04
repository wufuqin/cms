package com.cms.portal.controller.front;

import com.cms.context.utils.UtilsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 前台动态页面
 * @Author: 可乐
 * @Date: 20:40 2020/12/4
 */
@SuppressWarnings("all")
@Controller
public class DynamicPageController {

    /**
     * 去到前台首页
     * @return
     */
    @GetMapping("index.shtml")
    public String index(){
        return UtilsTemplate.adminTemplate("index");
    }








}



















