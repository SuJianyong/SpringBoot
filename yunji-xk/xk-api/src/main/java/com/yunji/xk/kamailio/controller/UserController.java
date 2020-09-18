package com.yunji.xk.kamailio.controller;


import com.yunji.common.common.ResponseInfo;
import com.yunji.xk.kamailio.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseInfo getAll() {
        log.info("abc");
        return new ResponseInfo(userService.getBaseMapper().selectList(null));
    }

}
