package com.emi2c.mybatis.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作类型注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Operating {

    /**
     * 操作类型：SELECT、INSERT、DELETE、UPDATE、START、ACTIVE
     * @return
     */
    String type() default "query";

}
