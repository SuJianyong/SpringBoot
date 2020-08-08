package com.yunji.xc.module.study.service.impl;

import com.yunji.xc.module.study.entity.User;
import com.yunji.xc.module.study.mapper.UserMapper;
import com.yunji.xc.module.study.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuJianyong
 * @since 2020-08-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
