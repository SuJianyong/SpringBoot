package com.yunji.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/10 10:35
 * @Modified:
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Value("${swagger.enable}")
    private boolean enable;

    @Value("${swagger.basePackage}")
    private String basePackage;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("Swagger文档")
                        .description("巡考系统swagger文档")
                        .version("9.0")
                        .license("系统体验版")
                        .licenseUrl("https://192.168.0.179/index2.jsp")
                        .build());
    }
}
