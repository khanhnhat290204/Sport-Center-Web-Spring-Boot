package com.nkn.SportCenter.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.JOSEException;
import com.nkn.SportCenter.dto.request.AuthRequest;
import com.nkn.SportCenter.dto.request.IntrospectRequest;
import com.nkn.SportCenter.service.AuthenticationService;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/auth/user")
    String authUser(@RequestBody AuthRequest request){
        return this.authService.authUser(request.getUsername(), request.getPassword());
    }

    @PostMapping("/token")
    boolean introspectToken(@RequestBody IntrospectRequest request) throws JOSEException, ParseException{
        return this.authService.introspectToken(request);
    }
}
