package com.yunji.xc.module.study.controller;


import com.yunji.xc.common.utils.RestResponse;
import com.yunji.xc.module.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SuJianyong
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public RestResponse getAll() {

        return RestResponse.ok(userService.getBaseMapper().selectList(null));
    }

}
