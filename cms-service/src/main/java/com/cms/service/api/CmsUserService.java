package com.cms.service.api;

import com.cms.core.foundation.BaseService;
import com.cms.service.dto.CmsUserDto;

/**
 * 用户副表service层接口
 *
 * @Author: 可乐
 * @Date: 17:12 2020/11/28
 */
@SuppressWarnings("all")
public interface CmsUserService extends BaseService<CmsUserDto, Integer> {

    /**
     * 根据用户名查找
     *
     * @param username
     * @return
     */
    public CmsUserDto selectByUsername(String username);



}




















