package com.wj.permission.entity;

import lombok.Data;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/25 0025
 * @description
 */
@Data
public class User {
  private Integer id;
  private String userName;
  private String password;
  private String role;
}
