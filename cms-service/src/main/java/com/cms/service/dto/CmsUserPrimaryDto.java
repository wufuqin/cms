package com.cms.service.dto;

import com.cms.core.foundation.BaseDto;

/**
 * 用户主表的dto类
 *      封装需要转换的字段
 * @Author: 可乐
 * @Date: 17:19 2020/11/28
 */
@SuppressWarnings("all")
public class CmsUserPrimaryDto extends BaseDto<Integer> {

    private String username;            // 用户名
    private String password;            // 用户密码，MD5加密或sha256散列加密
    private String salt;                // 密码盐
    private String email;               // 邮箱
    private Integer loginCount;         // 登陆次数
    private Boolean status;             // 状态
    private Boolean deleted;            // 是否已删除 0:删除 1正常

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
