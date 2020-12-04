package com.cms.service.dto;

import com.cms.core.foundation.BaseDto;

import java.time.LocalDateTime;

/**
 * 日志的Dto类
 *      封装需要进行转换的字段
 * @Author: 可乐
 * @Date: 20:30 2020/12/3
 */
@SuppressWarnings("all")
public class CmsLogDto extends BaseDto<Integer> {

    private Integer userId;    // 用户id
    private String username;   // 用户名称
    private String loginIp;    // ip地址
    private String url;        // URL地址
    private String content;    // 日志内容

    /**
     * 一次性set全部值
     * @param userId
     * @param username
     * @param loginIp
     * @param url
     * @param content
     * @return
     */
    public static CmsLogDto of(Integer userId,String username,String loginIp,String url,String content){
        CmsLogDto cmsLogDto = new CmsLogDto();
        cmsLogDto.setContent(content);
        cmsLogDto.setLoginIp(loginIp);
        cmsLogDto.setUserId(userId);
        cmsLogDto.setUsername(username);
        cmsLogDto.setUrl(url);
        return cmsLogDto;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

















