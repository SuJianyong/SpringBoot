package com.springboot.fileupload.service;

import com.springboot.fileupload.response.UploadFileResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/21 10:41
 * @描述
 */
public interface FileService {

    UploadFileResponse storeFile(MultipartFile file);

    Resource loadFileAsResource(String fileName);
}
