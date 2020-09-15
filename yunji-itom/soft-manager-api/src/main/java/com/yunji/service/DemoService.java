package com.yunji.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunji.common.common.ResponseInfo;
import com.yunji.dto.QueryDemoByPage;
import com.yunji.pojo.Demo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/10 11:35
 * @Modified:
 **/
public interface DemoService extends IService<Demo> {

    /**
     * 根据id查询demo
     * @param id 记录id
     * @return  demo
     */
    Demo getDemoById(int id) ;


    /**
     * 根据用户id查询demo
     * @param userId ：用户id
     * @return  demo
     */
    Demo getDemoByUserId(String userId) ;

    /**
     * 根据条件分页获取demo
     * @param query 参数对象
     * @return  分页对象
     */
    ResponseInfo getDemoByPage(@RequestBody QueryDemoByPage query) ;

}
