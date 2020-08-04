package com.spring.mp.user.controller;

import com.spring.mp.user.entity.User;
import com.spring.mp.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 苏健勇
 * @创建时间 2020/8/3 11:31
 * @描述
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/setObject")
    public void setObject() {
        User user = new User();
        user.setId("123");
        user.setName("包大人");
        redisUtils.set(user.getName(), user, 10);
    }

    @GetMapping("/getObject")
    public Object getObject(String key) {
        return redisUtils.get(key);
    }
}
