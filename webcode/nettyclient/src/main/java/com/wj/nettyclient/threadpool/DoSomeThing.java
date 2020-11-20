package com.wj.nettyclient.threadpool;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/18 0018
 * @description
 */
public class DoSomeThing {
  private ThreadPoolFactory factory;

  public DoSomeThing(ThreadPoolFactory factory) {
    this.factory = factory;
  }

  public void printThreadName() {
    for (int i = 1; i <= 10; i++) {
      factory
          .init()
          .execute(
              new Runnable() {
                @Override
                public void run() {
                  System.out.println(Thread.currentThread().getId());
                }
              });
    }
  }
}
