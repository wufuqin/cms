package com.cms.service.impl;

import com.cms.dao.mapper.CmsUserMapper;
import com.cms.service.api.CmsUserService;
import com.cms.service.converter.CmsUserConverter;
import com.cms.service.dto.CmsUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户副表service层实现类
 * @Author: 可乐
 * @Date: 17:12 2020/11/28
 */
@SuppressWarnings("all")
@Service
public class CmsUserServiceImpl implements CmsUserService {

    @Autowired
    private CmsUserMapper cmsUserMapper;

    /**
     * 根据用户名查找
     *
     * @param username
     * @return
     */
    @Override
    public CmsUserDto selectByUsername(String username) {
        return CmsUserConverter.CONVERTER.entityToDto(cmsUserMapper.getByUsername(username));
    }


    /**
     * 添加
     *
     * @param dto
     */
    @Override
    public void save(CmsUserDto dto) {
        cmsUserMapper.save(CmsUserConverter.CONVERTER.dtoToEntity(dto));
    }

    /**
     * 修改
     *
     * @param dto
     */
    @Override
    public void update(CmsUserDto dto) {
        cmsUserMapper.update(CmsUserConverter.CONVERTER.dtoToEntity(dto));
    }

    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     */
    @Override
    public CmsUserDto getById(Integer id) {
        return null;
    }
}



























