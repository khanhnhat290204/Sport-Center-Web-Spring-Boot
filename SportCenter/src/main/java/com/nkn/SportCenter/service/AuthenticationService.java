package com.nkn.SportCenter.service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.nkn.SportCenter.dto.request.IntrospectRequest;
import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.repository.UserRepository;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepo;

    @Value("${jwt.signerKey}")
    protected String SINGER_KEY;

    public String authUser(String username,String password){
        User user =this.userRepo.findByUsername(username);
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);

        boolean authenticated= passwordEncoder.matches(password,user.getPassword());
        
        if(!authenticated){
            throw new RuntimeException("Wrong Account Info");
        }

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

    public boolean introspectToken(IntrospectRequest request) throws JOSEException, ParseException{
        var token=request.getToken();

        JWSVerifier jwsVerifier= new MACVerifier(SINGER_KEY.getBytes());

        SignedJWT signedJWT= SignedJWT.parse(token);

        Date experityTime=signedJWT.getJWTClaimsSet().getExpirationTime();
        
        return signedJWT.verify(jwsVerifier) & experityTime.after(new Date()); 
    }
}
