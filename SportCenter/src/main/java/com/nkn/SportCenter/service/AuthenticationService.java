package com.nkn.SportCenter.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.repository.UserRepository;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepo;

    protected static final String SINGER_KEY="5a5636d96b4d43386e9f241c693d0c0b37f259339d17795c225694afb58882d1";

    public String authUser(String username,String password){
        User user =this.userRepo.findByUsername(username);
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);

        boolean authenticated= passwordEncoder.matches(password,user.getPassword());
        
        String token =generateToken(username);
        return token;
    }

    private String generateToken(String username){
        JWSHeader header= new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet=new JWTClaimsSet.Builder()
                                .subject(username).issuer("devteria.com")
                                .issueTime(new Date())
                                .expirationTime(new Date(Instant.now().plus(1,ChronoUnit.HOURS).toEpochMilli()))
                                .build();
        Payload payload= new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject=new JWSObject(header, payload);

        try{
            jwsObject.sign(new MACSigner(SINGER_KEY.getBytes()));
            return jwsObject.serialize();
        }catch(JOSEException ex){
            throw new RuntimeException(ex);
        }
    }
}
