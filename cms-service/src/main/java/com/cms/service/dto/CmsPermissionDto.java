package com.cms.service.dto;

import com.cms.core.foundation.BaseDto;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 权限菜单dto类
 * @Author: 可乐
 * @Date: 22:39 2020/12/7
 */
@SuppressWarnings("all")
public class CmsPermissionDto extends BaseDto<Integer> {

    private Integer parentId;                    // 父级id
    private Boolean menu;                        // 是否菜单 0:否 1:是
    private String  icon;                        // 菜单图标

    @NotBlank(message = "请输入权限名称")
    private String name;                         // 权限名称

    private String url;                          // 权限url
    private String action;                       // 权限码

    @NotNull(message = "请输入排序")
    @Min(value = 0,message = "排序最小只能到0")
    @Max(value = 99999,message = "排序最大只能到99999")
    private Integer priority;

    private List<CmsPermissionDto> children;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getMenu() {
        return menu;
    }

    public void setMenu(Boolean menu) {
        this.menu = menu;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<CmsPermissionDto> getChildren() {
        return children;
    }

    public void setChildren(List<CmsPermissionDto> children) {
        this.children = children;
    }
}
