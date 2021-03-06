package com.cms.service.dto;

import com.cms.core.foundation.BaseDto;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 站点配置的Dto
 * @Author: 可乐
 * @Date: 20:33 2020/12/5
 */
@SuppressWarnings("all")
public class CmsSiteDto extends BaseDto<Integer> {
    @NotBlank(message = "请输入站点名称")
    private String siteName;                    // 网站名称
    @NotBlank(message = "请输入站点关键字")
    private String keywords;                    // 站点关键字
    @NotBlank(message = "请输入站点描述")
    private String description;                 // 站点描述

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
