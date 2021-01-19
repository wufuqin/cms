package com.cms.service.impl;

import com.cms.dao.mapper.CmsPermissionMapper;
import com.cms.service.api.CmsPermissionService;
import com.cms.service.converter.CmsPermissionConverter;
import com.cms.service.dto.CmsPermissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限菜单的service实现类
 *
 * @Author: 可乐
 * @Date: 22:50 2020/12/7
 */
@SuppressWarnings("all")
@Service
public class CmsPermissionServiceImpl implements CmsPermissionService {

    @Autowired
    private CmsPermissionMapper cmsPermissionMapper;

    /**
     * 添加权限
     *
     * @param dto
     */
    @Override
    public void save(CmsPermissionDto dto) {
        cmsPermissionMapper.save(CmsPermissionConverter.CONVERTER.dtoToEntity(dto));
    }

    /**
     * 修改权限
     *
     * @param dto
     */
    @Override
    public void update(CmsPermissionDto dto) {

    }

    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     */
    @Override
    public CmsPermissionDto getById(Integer id) {
        return CmsPermissionConverter.CONVERTER.entityToDto(cmsPermissionMapper.selectById(id));
    }

    /**
     * 查询权限列表
     *
     * @param cmsPermissionDto
     * @return
     */
    @Override
    public List<CmsPermissionDto> getList(CmsPermissionDto cmsPermissionDto) {
        return CmsPermissionConverter.CONVERTER.entityToDto(cmsPermissionMapper.selectAll());
    }
}























