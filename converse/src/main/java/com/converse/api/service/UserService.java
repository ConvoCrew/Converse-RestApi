package com.converse.api.service;

import com.converse.api.model.Room;
import com.converse.api.model.User;
import com.converse.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
