package com.wj.jdbc.service;

import com.wj.jdbc.entity.User;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2021/1/4 0004
 * @description
 */
public interface UserService {
    /**
     * 新增
     * @param user
     * */
    void add(User user);


    /**
     * 查询
     * @return
     * */
    List<User> getList();

    /**
     * 修改
     * @param user
     * */
    void update(User user);

    /**
     * 删除
     * @param id
     * */
    void deleteById(String id);
}
