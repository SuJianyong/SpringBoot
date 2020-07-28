package com.springboot.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/22 10:18
 * @描述
 */
@Configuration
public class WebSocketConfig {

    // 如果单独放在外部tomcat运行，这个Bean需要注释掉
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
