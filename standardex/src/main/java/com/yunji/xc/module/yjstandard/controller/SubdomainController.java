package com.yunji.xc.module.yjstandard.controller;


import com.yunji.xc.common.utils.RestResponse;
import com.yunji.xc.module.study.entity.User;
import com.yunji.xc.module.study.service.UserService;
import com.yunji.xc.module.yjstandard.service.SubdomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SuJianyong
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/subdomain")
public class SubdomainController {

    @Autowired
    private SubdomainService subdomainService;
    @Autowired
    private UserService userService;


    @GetMapping("/getAll")
    public RestResponse getAll() {
        User user = new User();
        user.setCreateTime(new Date());
        user.setName("test");
        userService.getBaseMapper().insert(user);
        return RestResponse.ok(subdomainService.getBaseMapper().selectList(null));
    }
}
