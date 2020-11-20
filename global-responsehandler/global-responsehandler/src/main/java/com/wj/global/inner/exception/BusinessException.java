package com.wj.global.inner.exception;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/19 0019
 * @description 自定义业务异常
 */
public class BusinessException extends RuntimeException {

  private String code;

  private String msg;

  public BusinessException() {
    super();
  }

  public BusinessException(BaseErrorInfo errorInfo) {
    super(errorInfo.getCode());
    this.code = errorInfo.getCode();
    this.msg = errorInfo.getMsg();
  }

  public BusinessException(BaseErrorInfo errorInfo, Throwable cause) {
    super(errorInfo.getCode(), cause);
    this.code = errorInfo.getCode();
    this.msg = errorInfo.getMsg();
  }

  public BusinessException(String msg) {
    super(msg);
    this.msg = msg;
  }

  public BusinessException(String code, String msg) {
    super(code);
    this.code = code;
    this.msg = msg;
  }

  public BusinessException(String code, String msg, Throwable cause) {
    super(code, cause);
    this.code = code;
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
