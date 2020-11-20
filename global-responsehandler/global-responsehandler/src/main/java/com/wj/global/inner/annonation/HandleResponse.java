package com.wj.global.inner.annonation;

import java.lang.annotation.*;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/19 0019
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface HandleResponse {
}
