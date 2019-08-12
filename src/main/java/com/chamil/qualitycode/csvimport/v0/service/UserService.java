package com.chamil.qualitycode.csvimport.v0.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    void importUsers(MultipartFile file);
}
