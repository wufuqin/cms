package com.cms.service.converter;

import com.cms.dao.entity.CmsPermissionEntity;
import com.cms.service.dto.CmsPermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 权限菜单的数据转换类
 * @Author: 可乐
 * @Date: 22:45 2020/12/7
 */
@Mapper
@SuppressWarnings("all")
public interface CmsPermissionConverter {

    // 获取CmsPermissionConverter的 .class字节码文件，生成实现类
    public CmsPermissionConverter CONVERTER = Mappers.getMapper(CmsPermissionConverter.class);

    /**
     * 将权限菜单的dto转换为entity
     * @param dto
     * @return
     */
    public CmsPermissionEntity dtoToEntity(CmsPermissionDto dto);

    /**
     * 权限菜单的entity转换为dto
     * @param entity
     * @return
     */
    public CmsPermissionDto entityToDto(CmsPermissionEntity entity);

    /**
     * 将获取到的权限菜单列表从entity转换为dto
     * @param entity
     * @return
     */
    List<CmsPermissionDto> entityToDto(List<CmsPermissionEntity> entity);

}
