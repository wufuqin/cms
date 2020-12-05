package com.cms.context.utils;

/**
 * 封装跳转路径模板类
 * @Author: 可乐
 * @Date: 21:23 2020/12/4
 */
@SuppressWarnings("all")
public class UtilsTemplate {

    /**
     * 不让外界实例化该类
     */
    private UtilsTemplate() {
    }

    /**
     * 后台模板方法
     * @param template
     * @return              模板名称
     */
    public static String adminTemplate(String template){
        return "admin/"+template;
    }

    /**
     * 后台模板方法
     * @param dir       模板目录
     * @param template
     * @return          模板名称
     */
    public static String adminTemplate(String dir, String template) {
        return "admin/" + dir + "/" + template;
    }

    /**
     * 前台模板方法
     * @param template      模板
     * @return              模板名称
     */
    public static String filterTemplate(String template){
        return "filter/default/"+template;
    }

}
