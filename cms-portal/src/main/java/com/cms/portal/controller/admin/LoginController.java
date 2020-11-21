package com.cms.portal.controller.admin;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 后台登录控制器
 *
 * @Author: 可乐
 * @Date: 15:15 2020/11/21
 */
@SuppressWarnings("all")
@Controller
public class LoginController {

    // 注入验证码对象
    @Autowired
    private Producer captchaProducer;

    /**
     * 去到后台登录页面
     *
     * @return
     */
    @GetMapping("toLogin.do")
    public String toLogin() {
        return "admin/login";
    }

    /**
     * 生成验证码
     */
    @GetMapping("doCaptcha.do")
    public void doCaptcha(HttpServletResponse httpServletResponse) {
        // 生成验证码
        String text = captchaProducer.createText();
        // 生成验证码图片
        BufferedImage image = captchaProducer.createImage(text);

        // 方法二：将验证码图片响应到页面上，使用语法糖，不需要手动关闭流
        try (ServletOutputStream outputStream = httpServletResponse.getOutputStream()){
            ImageIO.write(image,"jpg",outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }

        // 方法一：将验证码图片响应到页面上，繁琐的方法
       /* ServletOutputStream outputStream = null;
        try {
            outputStream = httpServletResponse.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 将流关闭
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }


}



















