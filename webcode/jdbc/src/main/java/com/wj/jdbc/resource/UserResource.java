package com.wj.jdbc.resource;

import com.wj.jdbc.entity.User;
import com.wj.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 * @date 2021/1/4 0004
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        service.add(user);
    }

    @GetMapping("/list")
    public List<User> getList(){
        return service.getList();
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user){
        service.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void updateUser(@PathVariable("id") String id){
        service.deleteById(id);
    }


}
