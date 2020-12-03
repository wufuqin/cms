package com.cms.service.converter;

import com.cms.dao.entity.CmsLogEntity;
import com.cms.service.dto.CmsLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 日志表的字段转换类
 * @Author: 可乐
 * @Date: 20:39 2020/12/3
 */
@Mapper
@SuppressWarnings("all")
public interface CmsLogConverter {

    // 获取CmsUserPrimaryConverter的 .class字节码文件，生成实现类
    CmsLogConverter CONVERTER = Mappers.getMapper(CmsLogConverter.class);

    /**
     * 将日志的dto转换为entity
     * @param dto dto对象
     * @return
     */
    CmsLogEntity DtoToEntity(CmsLogDto dto);

    /**
     * 将日志的entity转换为dto
     * @param entity entity对象
     * @return
     */
    CmsLogDto entityToDto(CmsLogEntity entity);




}























