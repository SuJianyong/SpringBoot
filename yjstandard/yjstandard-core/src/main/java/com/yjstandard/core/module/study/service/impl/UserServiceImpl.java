package com.yjstandard.core.module.study.service.impl;

import com.yjstandard.core.module.study.entity.User;
import com.yjstandard.core.module.study.mapper.UserMapper;
import com.yjstandard.core.module.study.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuJianyong
 * @since 2020-08-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
