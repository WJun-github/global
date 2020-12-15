package com.wj.redis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
@Data
public class ResponseData implements Serializable {

    private String code;

    private String msg;

    private Object data;
}
