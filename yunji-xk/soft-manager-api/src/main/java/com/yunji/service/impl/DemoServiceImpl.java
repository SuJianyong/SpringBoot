package com.yunji.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunji.common.common.PageVo;
import com.yunji.common.common.ResponseInfo;
import com.yunji.dao.DemoMapper;
import com.yunji.dto.QueryDemoByPage;
import com.yunji.pojo.Demo;
import com.yunji.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/11 10:06
 * @Modified:
 **/
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

    @Override
    public Demo getDemoById(int id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Demo getDemoByUserId(String userId) {
        return baseMapper.getDemoByUserId(userId);
    }

    @Override
    public ResponseInfo getDemoByPage(QueryDemoByPage query){

        LambdaQueryWrapper<Demo> wrapper = new LambdaQueryWrapper<Demo>()
                .eq(StringUtils.isNotBlank(query.getUserId()), Demo::getUserId, query.getUserId())
                .like(StringUtils.isNotBlank(query.getUserName()), Demo::getUserName, query.getUserName())
                .like(StringUtils.isNotBlank(query.getUserAddress()), Demo::getUserAddress, query.getUserAddress())
                .orderByDesc(Demo::getId);
        // 查询第1页，每页返回5条
        Page<Demo> page = new Page<>(query.getNowPage(),query.getPageSize());
        IPage<Demo> iPage = baseMapper.selectPage(page,wrapper);
        PageVo pageVo = new PageVo(iPage);
        return new ResponseInfo(pageVo) ;
    }


}
