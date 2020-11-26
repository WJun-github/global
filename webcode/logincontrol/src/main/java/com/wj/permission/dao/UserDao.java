package com.wj.permission.dao;

import com.wj.permission.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
@Mapper
public interface UserDao {

  void register(User user);

  User loadUserByUsername(@Param("userName") String userName);

  List<User> list();

  void deleteById(@Param("id") Integer id);
}
