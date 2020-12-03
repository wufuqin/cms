package com.cms.dao.mapper;

import com.cms.core.foundation.BaseMapper;
import com.cms.dao.entity.CmsUserEntity;

/**
 * 用户副表的dao层接口
 * @Author: 可乐
 * @Date: 9:59 2020/11/29
 */
@SuppressWarnings("all")
public interface CmsUserMapper extends BaseMapper<CmsUserEntity,Integer> {

    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    public CmsUserEntity getByUsername(String username);


}
