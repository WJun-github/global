package com.wj.mongo.entitty.enums;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/14 0014
 * @description
 */
public enum CommonEnum {
  SUCCESS(200, "成功"),
  FAILURE(400, "失败"),
  ERROR(500, "服务器端错误");

  CommonEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  private Integer code;
  private String message;

  public Integer getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
