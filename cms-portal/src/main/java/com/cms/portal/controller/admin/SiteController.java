package com.cms.portal.controller.admin;

import com.cms.context.foundation.Result;
import com.cms.context.utils.UtilsTemplate;
import com.cms.core.annotation.DoValid;
import com.cms.service.api.CmsSiteService;
import com.cms.service.dto.CmsSiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 站点配置控制器
 * @Author: 可乐
 * @Date: 20:13 2020/12/5
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("site")
public class SiteController {

    @Autowired
    private CmsSiteService cmsSiteService;

    /**
     * 去到站点配置首页
     * @return
     */
    @GetMapping("index.do")
    public String toIndex(Model model){
        // 查询当前站点信息并且放入到model中
        model.addAttribute("data",cmsSiteService.get());
        // 返回指定的视图名称
        return UtilsTemplate.adminTemplate("site","index");
    }

    /**
     * 修改站点配置
     * @param cmsSiteDto
     * @param result
     * @return
     */
    @PostMapping("edit.do")
    @ResponseBody
    @DoValid
    public Result doEdit(@Valid CmsSiteDto cmsSiteDto, BindingResult result){
        cmsSiteService.update(cmsSiteDto);
        return Result.success("修改成功");
    }


}
















