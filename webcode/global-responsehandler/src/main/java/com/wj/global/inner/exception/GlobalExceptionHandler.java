package com.wj.global.inner.exception;

import com.wj.global.entity.ResultBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/19 0019
 * @description 全局异常捕获类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 自定义异常处理器
   *
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(value = BusinessException.class)
  public ResultBody businessExceptionHandler(HttpServletRequest request, BusinessException e) {
    return ResultBody.error(e.getCode(), e.getMsg());
  }

  /**
   * 通用异常处理器
   *
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(value = Exception.class)
  public ResultBody exceptionHandler(HttpServletRequest request, Exception e) {
    return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
  }
}
