package com.wj.permission.service.impl;

import com.wj.permission.dao.UserDao;
import com.wj.permission.entity.JwtUser;
import com.wj.permission.entity.User;
import com.wj.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public void register(User user) {
        dao.register(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = dao.loadUserByUsername(s);
        return new JwtUser(user);
    }

    @Override
    public List<User> list() {
        return dao.list();
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }
}
