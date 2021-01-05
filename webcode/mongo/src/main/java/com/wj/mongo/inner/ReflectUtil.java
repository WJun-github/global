package com.wj.mongo.inner;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/31 0031
 * @description 反射工具
 */
public interface  ReflectUtil<T> {

  /**
   * 处理对象的值，获取和设置
   * @param t
   * @param fieldName
   * @param value
   * @return
   */
  Object handle(T t, String fieldName, Object value);
}
