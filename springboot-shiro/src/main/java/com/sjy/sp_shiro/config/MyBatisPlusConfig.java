package com.sjy.sp_shiro.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/22 11:27
 * @描述
 */
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig {
    // 分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
