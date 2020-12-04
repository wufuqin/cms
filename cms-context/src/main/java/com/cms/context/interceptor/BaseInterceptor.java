package com.cms.context.interceptor;

import com.cms.core.foundation.BaseEntity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * mybatis的插件
 *      拦截器
 * @Author: 可乐
 * @Date: 19:47 2020/12/4
 */
@SuppressWarnings("all")
@Intercepts(
        @Signature(type = Executor.class, method = "update",args = {MappedStatement.class,Object.class})
)
public class BaseInterceptor implements Interceptor {

    /**
     * 拦截方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        switch (sqlCommandType){
            case INSERT:
                insert(invocation.getArgs()[1]);    // 传入第一个参数
                break;
            case UPDATE:
                update(invocation.getArgs()[1]);    // 传入第一个参数
                break;
            default:
                break;
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor){
            return Plugin.wrap(target,this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 添加操作 传递实体的话可以添加时间
     * @param obj
     */
    private void insert(Object obj){
        if(obj instanceof BaseEntity){
            BaseEntity baseEntity = (BaseEntity) obj;
            baseEntity.setCreateTime(LocalDateTime.now());
        }
    }

    /**
     * 修改时间
     * @param obj
     */
    private void update(Object obj){
        if(obj instanceof BaseEntity){
            BaseEntity baseEntity = (BaseEntity) obj;
            baseEntity.setUpdateTime(LocalDateTime.now());
        }
    }
}