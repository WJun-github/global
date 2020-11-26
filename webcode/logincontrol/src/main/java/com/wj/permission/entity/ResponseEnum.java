package com.wj.permission.entity;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
public enum ResponseEnum {
  SUCCESS("1", "操作成功"),
  FAILURE("0", "操作失败");

  ResponseEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  private String code;
  private String msg;

  public String getMsg() {
    return msg;
  }

  public String getCode() {
    return code;
  }

}
