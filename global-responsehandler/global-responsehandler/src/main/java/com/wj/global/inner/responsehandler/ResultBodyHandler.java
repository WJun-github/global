package com.wj.global.inner.responsehandler;

import com.alibaba.fastjson.JSON;
import com.wj.global.entity.ResultBody;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/20 0020
 * @description
 */
public class ResultBodyHandler implements HandlerMethodReturnValueHandler {
  @Override
  public boolean supportsReturnType(MethodParameter methodParameter) {
    boolean flag = false;
    Method method = methodParameter.getMethod();
    try {
      Object instance = method.getReturnType().newInstance();
      if (instance instanceof ResultBody) {
        return false;
      } else {
        flag = true;
      }
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return flag;
  }

  @Override
  public void handleReturnValue(
      Object o,
      MethodParameter methodParameter,
      ModelAndViewContainer modelAndViewContainer,
      NativeWebRequest nativeWebRequest)
      throws Exception {
    modelAndViewContainer.setRequestHandled(true);
    HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
    response.setContentType("application/json;charset=UTF-8");
    PrintWriter writer = null;
    try {
      writer = response.getWriter();
      writer.print(JSON.toJSONString(ResultBody.success(o)));
      writer.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (null != writer) {
        writer.close();
      }
    }
  }
}
