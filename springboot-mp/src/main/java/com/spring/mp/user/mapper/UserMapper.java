package com.spring.mp.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.mp.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sujy
 * @since 2020-07-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
