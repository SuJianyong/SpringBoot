package com.yunji.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunji.pojo.Demo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/11 10:06
 * @Modified:
 **/
@Mapper
public interface DemoMapper extends BaseMapper<Demo> {


    /**
     * 根据用户id查询demo
     * @param userId ：用户id
     * @return  demo
     */
    Demo getDemoByUserId(String userId);

}
