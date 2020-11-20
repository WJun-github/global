package com.wj.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wj.global")
public class GlobalResponseHandlerApplication {

  public static void main(String[] args) {
    SpringApplication.run(GlobalResponseHandlerApplication.class, args);
  }
}
