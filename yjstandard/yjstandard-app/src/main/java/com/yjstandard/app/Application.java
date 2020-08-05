package com.yjstandard.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yjstandard.core.module", "com.yjstandard.app.controller"})
@MapperScan(basePackages = "com.yjstandard.core.module")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
