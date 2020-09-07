package com.sjy.sp_shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.sp_shiro.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sujy
 * @since 2020-09-07
 */
public interface UserService extends IService<User> {
    void register(User user);

    User selectByUserName(String principal);
}
