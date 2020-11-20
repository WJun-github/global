package com.wj.nettyclient.threadpool;

import java.util.concurrent.ExecutorService;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/18 0018
 * @description
 */
public interface ThreadPoolFactory {


  /**
   * 初始化一个线程池
   *
   * @return
   */
  ExecutorService init();
}
