package com.sjy.sp_shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.sp_shiro.entity.User;
import com.sjy.sp_shiro.mapper.UserMapper;
import com.sjy.sp_shiro.service.UserService;
import com.sjy.sp_shiro.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sujy
 * @since 2020-09-07
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        user.setSalt(SaltUtils.getSalt(8));
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), user.getSalt(), 1024);
        user.setPassword(md5Hash.toString());
        userMapper.insert(user);
    }

    @Override
    public User selectByUserName(String principal) {

        return baseMapper.selectOne(new QueryWrapper<User>().eq("username", principal));
    }
}
