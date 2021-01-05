package com.wj.redis.resource;

import com.wj.redis.entity.ResponseData;
import com.wj.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/30 0030
 * @description
 */
@RestController
@RequestMapping("/string")
@Slf4j
public class StringResource {

    @Resource
    @Qualifier(value = "BeanRedisTemplate")
    private RedisTemplate<String,User> redisTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getName")
    public ResponseData getName(){
        ResponseData data=new ResponseData();
        User fiberhome = User.builder().name("fiberhome").age(20).build();
        redisTemplate.opsForValue().set("user",fiberhome);
        User user = redisTemplate.opsForValue().get("user");
        log.info("redisTemplate取到的内容：{}",user.toString());
        System.out.println("----------------");
        String name = stringRedisTemplate.opsForValue().get("name");
        log.info("stringRedisTemplate取到的内容：{}",name);
        data.setData(name);
        return data;
    }


}
