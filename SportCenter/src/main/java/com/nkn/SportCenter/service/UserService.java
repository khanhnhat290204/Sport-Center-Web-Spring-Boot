package com.nkn.SportCenter.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.UserRequest;
import com.nkn.SportCenter.dto.response.UserResponse;
import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.enums.Role;
import com.nkn.SportCenter.mapper.UserMapper;
import com.nkn.SportCenter.mapper.UserResponseMapper;
import com.nkn.SportCenter.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserResponseMapper userResponseMapper;

    public User createUser(UserRequest request){
        User user = this.userMapper.toUser(request);
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));;

        HashSet<String> roles=new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);

        return this.userRepo.save(user);
    }

    public UserResponse findUserById(int id){
        Optional<User> user_object= this.userRepo.findById(id);
        User user =user_object.get();
        return this.userResponseMapper.toUserResponse(user);
    }
}
