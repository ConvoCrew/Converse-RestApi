package com.converse.api.service;

import com.converse.api.model.Room;
import com.converse.api.model.User;
import com.converse.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long userId){
        try{
            userRepository.deleteById(userId);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public User updateUser(User user){return userRepository.save(user);}
}
