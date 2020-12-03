package com.cms.core.foundation;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础的dto类
 * @Author: 可乐
 * @Date: 9:33 2020/11/29
 */
@SuppressWarnings("all")
public class BaseDto<PK extends Serializable> implements Serializable {
    private PK id;                      // id
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 修改时间

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
