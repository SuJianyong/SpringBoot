package com.yunji.xk.yjstandard.controller;


import com.yunji.common.common.ResponseInfo;
import com.yunji.xk.kamailio.pojo.User;
import com.yunji.xk.kamailio.service.UserService;
import com.yunji.xk.yjstandard.service.SubdomainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "子域相关接口")
@RequestMapping(value = "/subdomain", produces = {"application/json; charset=UTF-8"})
public class SubdomainController {

    @Autowired
    private SubdomainService subdomainService;
    @Autowired
    private UserService userService;


    @GetMapping("/getAll")
    @ApiOperation("获取所有子域")
    public ResponseInfo getAll() {
        User user = new User();
        user.setCreateTime(new Date());
        user.setName("testAbc");
        userService.getBaseMapper().insert(user);
        return new ResponseInfo(subdomainService.getBaseMapper().selectList(null));
    }
}
