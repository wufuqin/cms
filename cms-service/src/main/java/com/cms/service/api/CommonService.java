package com.cms.service.api;

/**
 * 公共接口
 * @Author: 可乐
 * @Date: 14:41 2020/11/28
 */
@SuppressWarnings("all")
public interface CommonService {

    /**
     * 生成验证码
     */
    public void imageCaptcha();

    /**
     * 验证验证码是否正确
     * @param captcha
     * @return
     */
    public String verifyImageCaptcha(String captcha);


}
