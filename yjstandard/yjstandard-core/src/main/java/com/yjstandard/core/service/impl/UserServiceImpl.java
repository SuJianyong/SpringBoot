package com.yjstandard.core.service.impl;

import com.yjstandard.core.entity.User;
import com.yjstandard.core.UserMapper;
import com.yjstandard.core.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sujy
 * @since 2020-08-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
