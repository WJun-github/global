package com.wj.global.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wj.global.inner.exception.BaseErrorInfo;
import com.wj.global.inner.exception.CommonEnum;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/19 0019
 * @description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBody {

  private String code;

  private String msg;

  private Object data;

  public ResultBody() {}

  public ResultBody(BaseErrorInfo errorInfo) {
    this.code = errorInfo.getCode();
    this.msg = errorInfo.getMsg();
  }

  public static ResultBody success() {
    return success(null);
  }

  public static ResultBody success(Object data) {
    ResultBody resultBody = new ResultBody();
    resultBody.setCode(CommonEnum.SUCCESS.getCode());
    resultBody.setMsg(CommonEnum.SUCCESS.getMsg());
    resultBody.setData(data);
    return resultBody;
  }

  /** 失败 */
  public static ResultBody error(BaseErrorInfo errorInfo) {
    ResultBody resultBody = new ResultBody();
    resultBody.setCode(errorInfo.getCode());
    resultBody.setMsg(errorInfo.getMsg());
    resultBody.setData(null);
    return resultBody;
  }

  /** 失败 */
  public static ResultBody error(String code, String msg) {
    ResultBody resultBody = new ResultBody();
    resultBody.setCode(code);
    resultBody.setMsg(msg);
    resultBody.setData(null);
    return resultBody;
  }

  /** 失败 */
  public static ResultBody error(String msg) {
    ResultBody resultBody = new ResultBody();
    resultBody.setCode("-1");
    resultBody.setMsg(msg);
    resultBody.setData(null);
    return resultBody;
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

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
