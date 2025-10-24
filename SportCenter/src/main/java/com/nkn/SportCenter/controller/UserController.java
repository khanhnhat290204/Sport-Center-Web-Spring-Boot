package com.nkn.SportCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.UserRequest;
import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest request){
        return this.userService.createUser(request);
    }
}
