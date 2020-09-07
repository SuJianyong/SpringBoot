package com.sjy.sp_shiro.controller;

import com.sjy.sp_shiro.entity.User;
import com.sjy.sp_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @作者 苏健勇
 * @创建时间 2020/9/7 15:30
 * @描述
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public String login(User user) {
        try {
            userService.register(user);
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/register.jsp";
    }


    @RequestMapping("login")
    public String login(String username, String password) {

        // 获取主题对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误！");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误！");
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }
}
