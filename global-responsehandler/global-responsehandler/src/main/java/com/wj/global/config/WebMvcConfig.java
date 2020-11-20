package com.wj.global.config;

import com.wj.global.inner.responsehandler.ResultBodyHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/20 0020
 * @description 注册自定的返回值处理器。
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = handlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> list = new ArrayList<>();
        list.add(new ResultBodyHandler());
        list.addAll(returnValueHandlers);
        handlerAdapter.setReturnValueHandlers(list);
    }
}
