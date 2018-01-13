package com.xyz.app.controller;

import com.xyz.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 2018/1/6.
 */
@RestController
public class ExampleController {

    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String home(){
        userService.selectListUser();
        return "spring-boot-application";
    }
}
