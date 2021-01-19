package com.cms.service.api;

import com.cms.core.foundation.BaseService;
import com.cms.service.dto.CmsPermissionDto;

import java.util.List;

/**
 * 权限菜单的service接口
 * @Author: 可乐
 * @Date: 22:50 2020/12/7
 */
@SuppressWarnings("all")
public interface CmsPermissionService extends BaseService<CmsPermissionDto, Integer> {

    /**
     * 查询权限列表
     * @param cmsPermissionDto
     * @return
     */
    List<CmsPermissionDto> getList(CmsPermissionDto cmsPermissionDto);
}



















