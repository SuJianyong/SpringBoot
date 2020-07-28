package com.springboot.fileupload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/21 10:38
 * @描述
 */
@ConfigurationProperties(prefix = "file")
@Data
public class FileStorageProperties {

    private String uploadDir;
}
