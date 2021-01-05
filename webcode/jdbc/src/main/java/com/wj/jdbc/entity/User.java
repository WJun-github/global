package com.wj.jdbc.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wj
 * @version 1.0
 * @date 2021/1/4 0004
 * @description
 */
@Data
@Builder
public class User {
  private String id;
  private String name;
}
