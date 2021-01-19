package com.cms.core.foundation;

import java.io.Serializable;
import java.util.List;

/**
 * 基础的mapper类
 *      定义常用的增删改查抽象方法
 * @Author: 可乐
 * @Date: 21:24 2020/12/1
 */
@SuppressWarnings("all")
public interface BaseMapper<ENTITY extends BaseEntity<PK>,PK extends Serializable> {

    /**
     * 添加
     * @param entity
     */
    public void save(ENTITY entity);

    /**
     * 修改站点配置
     * @param entity
     */
    public void update(ENTITY entity);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public ENTITY selectById(PK id);

    /**
     * 查询所有
     * @return  list集合
     */
    List<ENTITY> selectAll();



}
























