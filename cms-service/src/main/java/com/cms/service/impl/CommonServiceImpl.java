package com.cms.service.impl;

import com.cms.context.utils.UtilsHttp;
import com.cms.context.utils.UtilsShiro;
import com.cms.service.api.CommonService;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 公共接口实现类型
 *
 * @Author: 可乐
 * @Date: 14:42 2020/11/28
 */
@SuppressWarnings("all")
@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    // 验证码常量
    private static final String IMAGE_CAPTCHA_SUFFIX = "image_captcha";

    // 注入验证码对象
    @Autowired
    private Producer captchaProducer;

    // 注入redis对象
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 生成验证码
     */
    @Override
    public void imageCaptcha() {

        // 生成验证码
        String text = captchaProducer.createText();
        // sessionId + "image_captcha" 将生成的验证码存入redis中，设置失效时间
        redisTemplate.opsForValue().set(UtilsShiro.getSession().getId() + IMAGE_CAPTCHA_SUFFIX, text, 60, TimeUnit.SECONDS);
        // 响应结果
        HttpServletResponse response = UtilsHttp.getResponse();
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 推荐大家自己来关闭response流
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(captchaProducer.createImage(text), "jpg", outputStream);
        } catch (IOException e) {
            log.error("验证码生成失败");
        }

    }

    /**
     * 验证验证码是否正确
     *
     * @param captcha
     * @return
     */
    @Override
    public String verifyImageCaptcha(String captcha) {

        // 获取redis中的验证码
        String redisCaptcha = redisTemplate.opsForValue().get(UtilsShiro.getSession().getId() + IMAGE_CAPTCHA_SUFFIX);

        // 判断验证码是否失效
        if (Objects.isNull(redisCaptcha)) {
            return "验证码已失效请重新输入!";
        }

        // 判断验证是否正确
        if(!StringUtils.equals(captcha,redisCaptcha)){
            return "验证码输入错误";
        }

        return null;
    }


}










