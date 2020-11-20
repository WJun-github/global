package com.wj.global.inner.exception;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/19 0019
 * @description
 */
public enum CommonEnum implements BaseErrorInfo {
  SUCCESS("200", "成功"),
  BODY_NOT_MATCH("400", "请求的数据格式不符!"),
  SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),
  NOT_FOUND("404", "未找到该资源!"),
  INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
  SERVER_BUSY("503", "服务器正忙，请稍后再试!");

  CommonEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  private String code;

  private String msg;

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getMsg() {
    return msg;
  }
}
