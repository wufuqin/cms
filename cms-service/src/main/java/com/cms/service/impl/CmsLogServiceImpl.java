package com.cms.service.impl;

import com.cms.dao.mapper.CmsLogMapper;
import com.cms.service.api.CmsLogService;
import com.cms.service.converter.CmsLogConverter;
import com.cms.service.dto.CmsLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 可乐
 * @Date: 21:38 2020/12/3
 */
@Service
@SuppressWarnings("all")
public class CmsLogServiceImpl implements CmsLogService {

    @Autowired
    private CmsLogMapper cmsLogMapper;

    /**
     * 添加
     *
     * @param dto
     */
    @Override
    public void save(CmsLogDto dto) {
        cmsLogMapper.save(CmsLogConverter.CONVERTER.DtoToEntity(dto));
    }

    /**
     * 修改
     *
     * @param dto
     */
    @Override
    public void update(CmsLogDto dto) {

    }

    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     */
    @Override
    public CmsLogDto getById(Integer id) {
        return null;
    }
}
