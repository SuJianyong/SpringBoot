package com.springboot.excel.user.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/29 15:26
 * @描述
 */
public interface UserService {
    String export(String basePath, HttpServletResponse response);
}
