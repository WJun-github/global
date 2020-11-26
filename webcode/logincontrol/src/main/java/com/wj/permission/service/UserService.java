package com.wj.permission.service;

import com.wj.permission.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/26 0026
 * @description
 */
public interface UserService extends UserDetailsService {
    void register(User user);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    List<User> list();

    void deleteById(Integer id);
}
