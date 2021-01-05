package com.wj.jdbc.service.impl;

import com.google.common.collect.Lists;
import com.wj.jdbc.config.ConnectionUtil;
import com.wj.jdbc.entity.ConnectionInfo;
import com.wj.jdbc.entity.User;
import com.wj.jdbc.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2021/1/4 0004
 * @description
 */
@Service
public class UserServiceImpl implements UserService, InitializingBean {

  @Autowired private ConnectionInfo info;

  private Connection connection;

  @Override
  public void add(User user) {
    try {
      String sql = "insert into users (id,name) values(?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, user.getId());
      preparedStatement.setString(2, user.getName());
      preparedStatement.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<User> getList() {
    try {
      List<User> list = Lists.newArrayList();
      String sql = "select * from users";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        User user = User.builder().id(id).name(name).build();
        list.add(user);
      }
      return list;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void update(User user) {
    try {
      String sql = "update users set name=? where id=?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getId());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteById(String id) {
    try {
      String sql = "delete from  users where id=?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    connection = ConnectionUtil.getConnection(info);
  }
}
