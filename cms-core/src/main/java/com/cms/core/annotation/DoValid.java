package com.cms.core.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *      通用验证的实现
 *              @Target 说明了Annotation所修饰的对象范围,我们只使用在方法上
 *              注解@Retention可以用来修饰注解,
 *              RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，
 *              jvm加载class文件之后，仍然存在；
 * @Author: 可乐
 * @Date: 18:33 2020/12/6
 */
@SuppressWarnings("all")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DoValid {
}




















