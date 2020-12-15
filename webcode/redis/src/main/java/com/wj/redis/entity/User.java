package com.wj.redis.entity;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/30 0030
 * @description
 */
@Builder
@ToString
public class User implements Serializable {
    private String name;

    private Integer age;

}
