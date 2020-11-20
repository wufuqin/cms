package com.cms.portal.controller.admin;

import com.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试web控制器
 * @Author: 可乐
 * @Date: 20:27 2020/11/20
 */
@Controller
@SuppressWarnings("all")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public void testController(){
        int count = testService.count();
        System.out.println(count);
    }

}
