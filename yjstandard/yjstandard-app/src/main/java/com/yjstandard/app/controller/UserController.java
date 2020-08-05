package com.yjstandard.app.controller;


import com.yjstandard.core.common.utils.RestResponse;
import com.yjstandard.core.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sujy
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUserById")
    public RestResponse getUserById(@Param("id") Integer id) {
        return RestResponse.ok(userService.getBaseMapper().selectById(id));
    }
}
