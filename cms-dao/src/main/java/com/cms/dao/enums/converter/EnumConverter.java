package com.cms.dao.enums.converter;

import com.cms.core.foundation.BaseEnum;
import com.cms.dao.enums.UserStatusEnum;

import java.util.Objects;

/**
 * 自定义转换规则
 *      entity中int类型转换为UserStatusEnum枚举类型
 * @Author: 可乐
 * @Date: 22:53 2020/12/1
 */
@SuppressWarnings("all")
public class EnumConverter {


    /**
     * 用于将dto中枚举转换为entity中的integer类型
     * @param Enumeration
     * @param <E>
     * @return
     */
    public static <E extends BaseEnum> Integer toInteger(E Enumeration) {
        return (Enumeration != null) ? Enumeration.getOrdinal() : null;
    }

    /**
     * 用于将entity中int类型转换为UserStatusEnum枚举类型
     * @param status
     * @return
     */
    public static UserStatusEnum toUserStatusEnum(int status) {
        return (UserStatusEnum)converter(UserStatusEnum.values(),status);
    }

    /**
     * 通用枚举转换器 统一循环枚举比对
     *
     * @param enums
     * @param status
     * @return
     */
    public static BaseEnum converter(BaseEnum[] enums, int status) {
        for (BaseEnum enumeration : enums) {
            if (Objects.equals(enumeration.getOrdinal(), status)) {
                return enumeration;
            }
        }
        return null;
    }



}















