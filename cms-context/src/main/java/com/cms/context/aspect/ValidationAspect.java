package com.cms.context.aspect;

import com.cms.context.foundation.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

/**
 * 基于aop自定义的注解验证
 * @Author: 可乐
 * @Date: 18:37 2020/12/6
 */
@SuppressWarnings("all")
@Component
@Aspect
public class ValidationAspect {

    /**
     *
     */
    @Pointcut("@annotation(com.cms.core.annotation.DoValid)")
    public void pointcut(){
    }

    /**
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        for(Object arg: point.getArgs()){
            if(arg instanceof BeanPropertyBindingResult){
                BindingResult bindingResult = (BindingResult) arg;
                if(bindingResult.hasErrors()){
                    return Result.failed(bindingResult.getFieldError().getDefaultMessage());
                }
            }
        }
        return point.proceed();
    }
}
