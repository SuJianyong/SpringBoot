package com.yjstandard.app.controller;


import com.yjstandard.core.common.utils.RestResponse;
import com.yjstandard.core.module.yjstandard.service.SubdomainService;
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
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/subdomain")
public class SubdomainController {

    @Autowired
    private SubdomainService subdomainService;

    @GetMapping("/getAll")
    public RestResponse getAll() {
        return RestResponse.ok(subdomainService.getBaseMapper().selectList(null));
    }
}
