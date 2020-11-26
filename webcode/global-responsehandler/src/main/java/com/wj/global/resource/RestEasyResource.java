package com.wj.global.resource;

import com.wj.global.entity.User;
import com.wj.global.inner.exception.BusinessException;
import org.apache.commons.lang.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/24 0024
 * @description
 */
@Path("/restEasy")
public class RestEasyResource {

  @GET
  @Path("/getUserName")
  public String getUserName() {
    User user = User.builder().name("python").birthDay("1986-01-01").build();
    if (StringUtils.equalsIgnoreCase(user.getName(), "Java")) {
      user.setBirthDay("1970-01-01");
    } else {
      throw new BusinessException("-1", "name can not match...");
    }
    return user.getBirthDay();
  }
}
