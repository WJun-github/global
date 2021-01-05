package com.wj.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author wj
 */
@SpringBootApplication
public class JdbcApplication {

  public static void main(String[] args) {
    SpringApplication.run(JdbcApplication.class, args);
  }
}
