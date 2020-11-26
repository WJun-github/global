package com.wj.permission.entity;

import lombok.Data;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
@Data
public class ResponseData {

    private String code;

    private String msg;

    private Object data;
}
