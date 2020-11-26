package com.wj.permission.resource;

import com.wj.permission.entity.ResponseData;
import com.wj.permission.entity.ResponseEnum;
import com.wj.permission.entity.User;
import com.wj.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserResource {

  @Autowired private UserService service;

  @GetMapping("/list")
  public ResponseData list() {
    ResponseData responseData = new ResponseData();
    try {
      List<User> data = service.list();
      responseData.setData(data);
      responseData.setCode(ResponseEnum.SUCCESS.getCode());
      responseData.setMsg(ResponseEnum.SUCCESS.getMsg());
    } catch (Exception e) {
      e.printStackTrace();
      responseData.setCode(ResponseEnum.FAILURE.getCode());
      responseData.setMsg(ResponseEnum.FAILURE.getMsg());
    }
    return responseData;
  }

  @DeleteMapping("/deleteById/{id}")
  public ResponseData deleteById(@PathVariable("id") Integer id){
    ResponseData responseData = new ResponseData();
    try {
      service.deleteById(id);
      responseData.setCode(ResponseEnum.SUCCESS.getCode());
      responseData.setMsg(ResponseEnum.SUCCESS.getMsg());
    } catch (Exception e) {
      e.printStackTrace();
      responseData.setCode(ResponseEnum.FAILURE.getCode());
      responseData.setMsg(ResponseEnum.FAILURE.getMsg());
    }
    return responseData;
  }
}
