package com.wj.permission.resource;

import com.wj.permission.entity.User;
import com.wj.permission.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthorizationResource {

  @Autowired private UserService service;

  @Autowired private BCryptPasswordEncoder encoder;

  @PostMapping("/register")
  public String register(@RequestBody User user) {
    try {
      user.setPassword(encoder.encode(user.getPassword()));
      log.info("password:{}", user.getPassword());
      service.register(user);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
  }
}
