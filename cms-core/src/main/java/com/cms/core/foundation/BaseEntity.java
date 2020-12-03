package com.cms.core.foundation;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础的用户实体类
 * @Author: 可乐
 * @Date: 9:47 2020/11/29
 */
@SuppressWarnings("all")
public class BaseEntity<PK extends Serializable> implements Serializable {
    private PK id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}

