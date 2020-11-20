package com.wj.global.resource;

import com.wj.global.entity.User;
import com.wj.global.inner.exception.BusinessException;
import com.wj.global.inner.exception.CommonEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/19 0019
 * @description
 */
@RestController
@RequestMapping("/thread")
public class GlobalResource {

  @PostMapping("/insert")
  public User insert(@RequestBody User user) {
    if (StringUtils.equalsIgnoreCase("Jack", user.getName())) {
      throw new BusinessException(CommonEnum.BODY_NOT_MATCH);
    }
    User build = User.builder().name(user.getName()).birthDay("2020-11-11").build();
    return build;
  }

  @GetMapping("/getById/{id}")
  public User getUser(@PathVariable("id") String id) {
    int i = 10 / 0;
    return User.builder().name("tom").birthDay("2020-11-11").gender("男").build();
  }

  @GetMapping("/getUserByName/{name}")
  public User getUserByName(@PathVariable("name") String name){
    User user = User.builder().name("java").birthDay("1989").gender("男").build();
    if(StringUtils.equalsIgnoreCase(name,user.getName())){
      return user;
    }
    return null;
  }
}
