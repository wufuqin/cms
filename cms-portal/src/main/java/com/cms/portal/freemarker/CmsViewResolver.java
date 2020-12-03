package com.cms.portal.freemarker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 视图解析器：
 *      使用freemarker来获取项目的绝对路径
 * @Author: 可乐
 * @Date: 20:52 2020/11/25
 */
@SuppressWarnings("all")
@Slf4j
public class CmsViewResolver extends FreeMarkerView {

    private static final String ADMIN_PATH = "/admin/cms/";

    /**
     * 获取项目的路径，加入模板中
     * @param model
     * @param request
     * @throws Exception
     */
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        // 获取项目的根路径
        String contextPath = request.getContextPath();
        // 获取能够与web.xml中的<servlet-mapping>标签中“url-pattern”中匹配的路径，注意是完全匹配的部分，*的部分不包括
        String servletPath = request.getServletPath();
        // 返回除去host（域名或者ip）部分的路径
        String requestURI = request.getRequestURI();

        if(requestURI.contains(ADMIN_PATH)){
            // 带有 /admin/cms/ 判断为后台路径
            model.put("adminPath",contextPath+servletPath);
        }

        model.put("basePath",contextPath);
    }
}























