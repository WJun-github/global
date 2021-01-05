package com.wj.mongo.inner;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/31 0031
 * @description
 */
public class GetUtil<T>  implements ReflectUtil<T>, InitializingBean {
    @Override
    public Object handle(T t, String fieldName, Object value) {
        PropertyUtilsBean propertyUtilsBean=new PropertyUtilsBean();
        PropertyDescriptor[] propertyDescriptors = propertyUtilsBean.getPropertyDescriptors(t);
        for(PropertyDescriptor propertyDescriptor:propertyDescriptors){
            if(StringUtils.equalsIgnoreCase(propertyDescriptor.getName(),fieldName)){
                Method method = propertyDescriptor.getReadMethod();
                try {
                    Object fieldValue = method.invoke(t);
                    return fieldValue;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
