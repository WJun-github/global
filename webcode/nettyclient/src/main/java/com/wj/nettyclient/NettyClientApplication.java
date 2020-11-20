package com.wj.nettyclient;

import com.wj.nettyclient.threadpool.DoSomeThing;
import com.wj.nettyclient.threadpool.FixTreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
public class NettyClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(NettyClientApplication.class, args);
    new DoSomeThing(new FixTreadPool()).printThreadName();
  }
}
