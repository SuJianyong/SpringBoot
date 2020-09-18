package com.yunji.xk.kamailio.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunji.xk.kamailio.dao.UserMapper;
import com.yunji.xk.kamailio.pojo.User;
import com.yunji.xk.kamailio.service.UserService;
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
