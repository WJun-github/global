package com.wj.nettyserver;

import com.wj.nettyserver.server.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** @author Administrator */
@SpringBootApplication
public class NettyServerApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(NettyServerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    NettyServer server = new NettyServer();
    server.start();
  }
}
