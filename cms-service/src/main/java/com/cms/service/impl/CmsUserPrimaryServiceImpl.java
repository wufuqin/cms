package com.cms.service.impl;

import com.cms.dao.mapper.CmsUserPrimaryMapper;
import com.cms.service.api.CmsUserPrimaryService;
import com.cms.service.converter.CmsUserPrimaryConverter;
import com.cms.service.dto.CmsUserPrimaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户主表service
 * @Author: 可乐
 * @Date: 21:15 2020/12/1
 */
@Service
@SuppressWarnings("all")
public class CmsUserPrimaryServiceImpl implements CmsUserPrimaryService {

    @Autowired
    private CmsUserPrimaryMapper cmsUserPrimaryMapper;

    /**
     * 向用户主表中添加数据
     *
     * @param dto
     */
    @Override
    public void save(CmsUserPrimaryDto dto) {

    }

    /**
     * 修改
     *
     * @param dto
     */
    @Override
    public void update(CmsUserPrimaryDto dto) {

    }

    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     */
    @Override
    public CmsUserPrimaryDto getById(Integer id) {
        return CmsUserPrimaryConverter.CONVERTER.entityToDto(cmsUserPrimaryMapper.selectById(id));
    }

}





















