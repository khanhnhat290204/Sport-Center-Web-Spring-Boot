package com.nkn.SportCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.UserRequest;
import com.nkn.SportCenter.dto.response.UserResponse;
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

    @GetMapping("/user/{id}")
    public UserResponse findUserById(@PathVariable int id){
        var authentication= SecurityContextHolder.getContext().getAuthentication();

        System.out.println(authentication.getName());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getAuthorities());
        return this.userService.findUserById(id);
    }
}
