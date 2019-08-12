package com.chamil.qualitycoder.csvimport.v0.controller;

import com.chamil.qualitycoder.csvimport.v0.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public void handleFile(@RequestParam MultipartFile file){

        if(!StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),"csv")){
            throw new IllegalArgumentException("Only CSV allowed.");
        }
        userService.importUsers(file);
    }
}
