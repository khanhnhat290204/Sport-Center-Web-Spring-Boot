package com.nkn.SportCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.AuthRequest;
import com.nkn.SportCenter.service.AuthenticationService;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/auth/user")
    String authUser(@RequestBody AuthRequest request){
        return this.authService.authUser(request.getUsername(), request.getPassword());
    }
}
