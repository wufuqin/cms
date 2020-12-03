package com.cms.core.foundation;

import java.io.Serializable;

/**
 * 基础的service接口
 *      定义常用的增删改查抽象方法
 * @Author: 可乐
 * @Date: 21:11 2020/12/1
 */
@SuppressWarnings("all")
public interface BaseService<DTO extends BaseDto<PK>,PK extends Serializable> {

    /**
     * 添加
     * @param dto
     */
    public void save(DTO dto);

    /**
     * 修改
     * @param dto
     */
    public void update(DTO dto);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    public DTO getById(PK id);


}
