package com.example.sysdemo.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    String fileUrl(MultipartFile file);
}
