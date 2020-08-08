package com.yunji.xc;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
public class XcApplication {

    public static void main(String[] args) {
        SpringApplication.run(XcApplication.class, args);
    }

}
