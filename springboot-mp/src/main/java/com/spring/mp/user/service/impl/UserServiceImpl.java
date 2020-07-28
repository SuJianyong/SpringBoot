package com.spring.mp.user.service.impl;

import com.spring.mp.user.entity.User;
import com.spring.mp.user.mapper.UserMapper;
import com.spring.mp.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sujy
 * @since 2020-07-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
