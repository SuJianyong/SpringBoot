package com.springboot.excel.user.controller;

import com.springboot.excel.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/29 15:22
 * @描述
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("export")
    public String exportExcel(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {

//        String basePath = request.getSession().getServletContext().getRealPath("/templates");
//        ClassPathResource cpr = new ClassPathResource("/templates/" + "user.xlsx");
//        String serverpath = ResourceUtils.getURL("classpath:templates/user.xlsx").getPath().replace("%20"," ").replace('/', '\\');
//        String basePath = serverpath.substring(1);//从路径字符串中取出工程路
        String basePath = "E:/github-project/springboot-excel/src/main/resources/templates/user.xlsx";
        String uri = userService.export(basePath, response);
        return null;
    }
}
