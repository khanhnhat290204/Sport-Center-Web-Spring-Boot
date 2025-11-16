package com.nkn.SportCenter.configuration;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.enums.Role;
import com.nkn.SportCenter.repository.UserRepository;

@Configuration
public class ApplicationInitConfig {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepo){
        return args->{
            var roles=new HashSet<String>();
            roles.add(Role.ADMIN.name());
            if(userRepo.findByUsername("admin")==null){
                User user= User.builder()
                            .username("admin")
                            .password(passwordEncoder.encode("admin"))
                            .roles(roles)
                            .build();

                userRepo.save(user);
                System.out.println("admin user has been created");
            }
        };
    }
}
