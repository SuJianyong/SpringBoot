package com.springboot.excel.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/29 15:44
 * @描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String Id;
    private String userName;
    private String head;
    private int sex;
    private String phone;
}
