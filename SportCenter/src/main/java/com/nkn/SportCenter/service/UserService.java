package com.nkn.SportCenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.UserRequest;
import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.mapper.UserMapper;
import com.nkn.SportCenter.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserMapper userMapper;

    public User createUser(UserRequest request){
        User user = this.userMapper.toUser(request);
        return this.userRepo.save(user);
    }

    public User findUserById(int id){
        Optional<User> user_object= this.userRepo.findById(id);
        User user =user_object.get();
        return user;
    }
}
