package com.spring.mp.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.mp.user.entity.User;
import com.spring.mp.user.service.UserService;
import com.spring.mp.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sujy
 * @since 2020-07-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // select
    @ResponseBody
    @GetMapping("/selectById")
    public User selectById() {
        User user = userService.getBaseMapper().selectById(1);
        return user;
    }
    @ResponseBody
    @GetMapping("/selectByCondition")
    public List<User> selectByCondition() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "2");
        List<User> users = userService.getBaseMapper().selectByMap(map);
        return users;
    }
    @ResponseBody
    @GetMapping("/selectByBatchIds")
    public List<User> selectByBatchIds() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        List<User> users = userService.getBaseMapper().selectBatchIds(idList);
        return users;
    }
    @ResponseBody
    @GetMapping("/selectByPage")
    public PageUtils selectByPage() {
        // myBatisPlus配置分页插件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "123");
        IPage<User> page = new Page<>(1,2);
        IPage<User> userIPage = userService.getBaseMapper().selectPage(page, wrapper);
        System.out.println("总条数"+userIPage.getTotal());
        System.out.println("总页数"+userIPage.getPages());
        return new PageUtils(userIPage);
    }
    @ResponseBody
    @GetMapping("/selectByMapsPage")
    public PageUtils selectByMapsPage() {
        // myBatisPlus配置分页插件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "123");
        Page<User> page = new Page<>(1, 2);
        IPage<Map<String,Object>> userIPage = userService.getBaseMapper().selectMapsPage(page, wrapper);
        System.out.println("总条数"+userIPage.getTotal());
        System.out.println("总页数"+userIPage.getPages());
        return new PageUtils(userIPage);
    }
    // insert
    @PostMapping("/insert")
    public void insert(String name) {
        User user = new User();
        user.setName(name);
        userService.getBaseMapper().insert(user);
    }
    // update
    @PostMapping("/update")
    public void update() {
        User user = userService.getBaseMapper().selectById(1);
        user.setName("mp测试更新");
        userService.updateById(user);
    }
    // delete
    @PostMapping("/delete")
    public void delete() {
        userService.getBaseMapper().deleteById("1");
    }
    @PostMapping("/deleteByContition")
    public void deleteByContition() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "123");
        userService.getBaseMapper().deleteByMap(map);
    }
    @PostMapping("/deleteByBatchIds")
    public void deleteByBatchIds() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        userService.getBaseMapper().deleteBatchIds(idList);
    }
}
