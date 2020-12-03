package com.cms.service.converter;

import com.cms.dao.entity.CmsUserEntity;
import com.cms.dao.enums.converter.EnumConverter;
import com.cms.service.dto.CmsUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户副表的字段转换类
 *
 * @Author: 可乐
 * @Date: 10:08 2020/11/29
 */
@SuppressWarnings("all")
@Mapper(uses = EnumConverter.class)  // 引入自定义的转换规则
public interface CmsUserConverter {

    // 获取CmsUserPrimaryConverter的 .class字节码文件，生成实现类
    CmsUserConverter CONVERTER = Mappers.getMapper(CmsUserConverter.class);

    /**
     * 将CmsUserDto实体类对象当做参数传入，交由其自动转换
     *      Dto转换为实体类entity
     * @param dto
     * @return
     */
    CmsUserEntity dtoToEntity(CmsUserDto dto);

    /**
     * 将CmsUserEntity实体类对象当做参数传入，交由其自动转换
     *      实体类entity转换为Dto
     * @param entity
     * @return
     */
    CmsUserDto entityToDto(CmsUserEntity entity);

}
