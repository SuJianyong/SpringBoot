package com.spring.mp.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/29 11:23
 * @描述
 */
/**
 * Druid 多数据源配置
 * @Primary 注解默认为主数据源
 */
@Configuration
public class MultiDataSourceConfig {
    @Primary
    @Bean(name = "study")
    @ConfigurationProperties("spring.datasource.druid.study")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "study2")
    @ConfigurationProperties("spring.datasource.druid.study2")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
