package com.cms.service.converter;

import com.cms.dao.entity.CmsSiteEntity;
import com.cms.service.dto.CmsSiteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 站点配置的数据转换接口
 * @Author: 可乐
 * @Date: 20:40 2020/12/5
 */
@SuppressWarnings("all")
@Mapper
public interface CmsSiteConverter {

    // CmsSiteConverter .class字节码文件，生成实现类
    CmsSiteConverter CONVERTER = Mappers.getMapper(CmsSiteConverter.class);

    /**
     * 将站点配置的dto转换为entity
     * @param dto
     * @return
     */
    CmsSiteEntity dtoToEntity(CmsSiteDto dto);

    /**
     * 将站点配置的entity转换为dto
     * @param entity
     * @return
     */
    CmsSiteDto entityToDto(CmsSiteEntity entity);
}
