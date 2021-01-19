package com.cms.portal.controller.admin;

import com.cms.context.foundation.Result;
import com.cms.context.utils.UtilsTemplate;
import com.cms.core.annotation.DoLog;
import com.cms.core.annotation.DoValid;
import com.cms.dao.enums.PermissionTypeEnum;
import com.cms.service.api.CmsPermissionService;
import com.cms.service.dto.CmsPermissionDto;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 权限菜单控制器
 *
 * @Author: 可乐
 * @Date: 22:55 2020/12/7
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private CmsPermissionService cmsPermissionService;

    /**
     * 去到权限分配首页
     *
     * @return
     */
    @GetMapping("index.do")
    public String toIndex() {
        return UtilsTemplate.adminTemplate("permission", "index");
    }

    /**
     * 去到权限添加页面
     *
     * @return
     */
    @GetMapping("add.do")
    public String toAdd(Integer parentId, Model model) {
        // 判断获取到的权限父节点的id是否为空
        if (Objects.nonNull(parentId)) {
            model.addAttribute("parentId", parentId);
        }
        // 将获取到的值存入model
        model.addAttribute("permissionType", PermissionTypeEnum.values());
        return UtilsTemplate.adminTemplate("permission", "add");
    }

    /**
     * 执行权限添加操作
     *
     * @param cmsPermissionDto
     * @return
     */
    @PostMapping("add.do")
    @ResponseBody
    @DoLog(content = "添加权限")
    @DoValid
    public Result<String> doAdd(@Valid CmsPermissionDto cmsPermissionDto, BindingResult result) {
        cmsPermissionService.save(cmsPermissionDto);
        return Result.success("添加成功");
    }

    /**
     * 查询权限树的所有数据
     *
     * @param cmsPermissionDto
     * @return
     */
    @GetMapping("list.do")
    @ResponseBody
    public Result doList(CmsPermissionDto cmsPermissionDto) {
        return Result.success((ArrayList) cmsPermissionService.getList(cmsPermissionDto));
    }

    /**
     * 显示权限树
     *
     * @return
     */
    @PostMapping("selectTree.do")
    @ResponseBody
    public Result doSelectTree(Integer excludeId) {
        List<CmsPermissionDto> cmsPermissionDtos = buildData();
        //存放所有数据 方便存取
        Map<Integer, CmsPermissionDto> permissionMap = Maps.newHashMap();
        //只存放parentId = 0的数据
        List<CmsPermissionDto> permissionList = Lists.newArrayList();
        //循环数据 进行处理
        cmsPermissionDtos.forEach(x -> {
            Integer id = x.getId();
            //如果当前id 等于 排除的id跳过
            if (Objects.nonNull(excludeId) && id.compareTo(excludeId) == 0) {
                return;
            }
            permissionMap.put(id, x);
            //获取当前dto的父类id
            Integer parentId = x.getParentId();
            //判断是否是顶级菜单
            if (parentId == 0) {
                permissionList.add(x);
            } else {
                CmsPermissionDto cmsPermissionDto = permissionMap.get(parentId);
                if (Objects.isNull(cmsPermissionDto) && Objects.nonNull(excludeId) && parentId.compareTo(excludeId) == 0) {
                    return;
                }
                List<CmsPermissionDto> children = cmsPermissionDto.getChildren();
                if (CollectionUtils.isEmpty(children)) {
                    children = Lists.newArrayList();
                }
                children.add(x);
                cmsPermissionDto.setChildren(children);
            }
        });
        return Result.success((ArrayList) permissionList);
    }

    /**
     * 去到修改页面,同时查询处需要修改的对应信息
     * @return
     */
    @GetMapping("edit.do")
    public String toEdit(Integer id, Model model){
        // 查询出需要修改的数据，并且放入到model中
        model.addAttribute("data",cmsPermissionService.getById(id));
        // 权限的类型
        model.addAttribute("permissionType",PermissionTypeEnum.values());
        return UtilsTemplate.adminTemplate("permission", "edit");
    }

    /**
     * 构建一个测试的权限树
     *
     * @return
     */
    public List<CmsPermissionDto> buildData() {
        List<CmsPermissionDto> permissionList = Lists.newArrayList();
        //4条数据
        CmsPermissionDto cmsPermissionDto = new CmsPermissionDto();
        CmsPermissionDto cmsPermissionDto2 = new CmsPermissionDto();
        CmsPermissionDto cmsPermissionDto3 = new CmsPermissionDto();
        CmsPermissionDto cmsPermissionDto4 = new CmsPermissionDto();

        cmsPermissionDto.setId(1);
        cmsPermissionDto2.setId(2);
        cmsPermissionDto3.setId(3);
        cmsPermissionDto4.setId(4);

        cmsPermissionDto.setName("测试");
        cmsPermissionDto2.setName("测试2");
        cmsPermissionDto3.setName("测试3");
        cmsPermissionDto4.setName("测试4");

        cmsPermissionDto.setParentId(0);
        cmsPermissionDto2.setParentId(1);
        cmsPermissionDto3.setParentId(2);
        cmsPermissionDto4.setParentId(3);

        permissionList.add(cmsPermissionDto);
        permissionList.add(cmsPermissionDto2);
        permissionList.add(cmsPermissionDto3);
        permissionList.add(cmsPermissionDto4);
        return permissionList;
    }

}





















