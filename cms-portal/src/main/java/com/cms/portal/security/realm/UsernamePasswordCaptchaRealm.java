package com.cms.portal.security.realm;

import com.cms.dao.enums.UserStatusEnum;
import com.cms.service.api.CmsUserPrimaryService;
import com.cms.service.api.CmsUserService;
import com.cms.service.dto.CmsUserDto;
import com.cms.service.dto.CmsUserPrimaryDto;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * 验证登录，校验权限
 * @Author: 可乐
 * @Date: 16:39 2020/11/22
 */
@SuppressWarnings("all")
public class UsernamePasswordCaptchaRealm extends AuthorizingRealm {

    @Autowired
    private CmsUserService cmsUserService;

    @Autowired
    private CmsUserPrimaryService cmsUserPrimaryService;

    /**
     * 获取登录信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 检查权限
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 拿到username
        String username = (String) authenticationToken.getPrincipal();
        // 1. 根据用户名先在副表中查找是否存在
        CmsUserDto cmsUserDto = cmsUserService.selectByUsername(username);
        if (Objects.isNull(cmsUserDto)){
            throw new UnknownAccountException();
        }
        // 2. 校验用户的状态，是否已经被禁用
        verifyStatus(cmsUserDto.getStatus());
        //查询用户主表信息
        CmsUserPrimaryDto cmsUserPrimaryDto = cmsUserPrimaryService.getById(cmsUserDto.getId());
        // 比对主表与副表的密码是否一致
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(cmsUserDto, cmsUserPrimaryDto.getPassword(), ByteSource.Util.bytes(cmsUserPrimaryDto.getSalt()), getName());
        // 清理认证信息
        super.clearCachedAuthenticationInfo(simpleAuthenticationInfo.getPrincipals());
        return simpleAuthenticationInfo;
    }

    /**
     * 校验状态
     * @param userStatusEnum
     */
    private void verifyStatus(UserStatusEnum userStatusEnum){
        if(UserStatusEnum.DISABLED.equals(userStatusEnum)){
            throw new DisabledAccountException("该账号已被禁用,请联系管理员!");
        }
        if(UserStatusEnum.LOCKED.equals(userStatusEnum)){
            throw new DisabledAccountException("该账号已被锁定,请联系管理员!");
        }
        if(UserStatusEnum.UNACTIVATED.equals(userStatusEnum)){
            throw new DisabledAccountException("该账号未激活,请联系管理员!");
        }
    }



}



























