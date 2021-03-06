package com.xyz.app.controller;

import com.xyz.app.entity.CsUser;
import com.xyz.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 2018/1/6.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("get")
    public Object home(@RequestParam("userId") Long userId){
        return userService.findUserById(userId);
    }

    @RequestMapping("list")
    public Object home(CsUser user){
        return userService.findUserList(user);
    }
}
