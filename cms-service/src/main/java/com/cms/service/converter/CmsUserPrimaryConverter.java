package com.cms.service.converter;

import com.cms.dao.entity.CmsUserPrimaryEntity;
import com.cms.service.dto.CmsUserPrimaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 主表副表的字段转换类
 *      数据传输对象，请求和返回对象(dto <=> Entity)
 * @Author: 可乐
 * @Date: 17:21 2020/11/28
 */
@Mapper
@SuppressWarnings("all")
public interface CmsUserPrimaryConverter {

    /**
     * 获取CmsUserPrimaryConverter的 .class字节码文件，生成实现类
     */
    CmsUserPrimaryConverter CONVERTER = Mappers.getMapper(CmsUserPrimaryConverter.class);

    /**
     * 将CmsUserPrimaryEntity实体类对象当做参数传入，交由其自动转换
     * @param entity
     * @return
     */
    CmsUserPrimaryDto entityToDto(CmsUserPrimaryEntity entity);


}




















