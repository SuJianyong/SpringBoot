package com.yjstandard.app;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude= {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class})

@SpringBootApplication(
        exclude= {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.yjstandard.core.module.**", "com.yjstandard.app.controller"})
@MapperScan(basePackages = {"com.yjstandard.core.module.**.mapper"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
