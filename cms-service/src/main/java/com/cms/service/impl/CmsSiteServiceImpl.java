package com.cms.service.impl;

import com.cms.dao.mapper.CmsSiteMapper;
import com.cms.service.api.CmsSiteService;
import com.cms.service.converter.CmsSiteConverter;
import com.cms.service.dto.CmsSiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 站点配置的service实现类
 * @Author: 可乐
 * @Date: 20:47 2020/12/5
 */
@SuppressWarnings("all")
@Service
public class CmsSiteServiceImpl implements CmsSiteService {

    @Autowired
    private CmsSiteMapper cmsSiteMapper;

    /**
     * 添加
     *
     * @param dto
     */
    @Override
    public void save(CmsSiteDto dto) {

    }

    /**
     * 修改站点配置
     *
     * @param dto
     */
    @Override
    public void update(CmsSiteDto dto) {
        cmsSiteMapper.update(CmsSiteConverter.CONVERTER.dtoToEntity(dto));
    }

    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     */
    @Override
    public CmsSiteDto getById(Integer id) {
        return null;
    }

    /**
     * 查询当前站点的信息
     *
     * @return
     */
    @Override
    public CmsSiteDto get() {
        return CmsSiteConverter.CONVERTER.entityToDto(cmsSiteMapper.selectById(1));
    }
}





























