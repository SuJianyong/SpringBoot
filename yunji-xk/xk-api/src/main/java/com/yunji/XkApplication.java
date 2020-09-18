package com.yunji;

import com.yunji.common.softmanager.vo.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XkApplication {

    public static void main(String[] args) {
        SpringApplication.run(XkApplication.class, args);
    }

    public void test(){
        Test test = new Test() ;

    }

}
