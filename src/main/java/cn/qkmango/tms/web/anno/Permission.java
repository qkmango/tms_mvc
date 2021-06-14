package cn.qkmango.tms.web.anno;


import cn.qkmango.tms.web.bind.PermissionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 用户权限控制注解
 * 在控制器方法上使用，指定控制器方法允许的用户类型
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    PermissionType[] value() default {
            PermissionType.student,
            PermissionType.teacher,
            PermissionType.admin
    };
}