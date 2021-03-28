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
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Boolean deleteUser(Long userId) {
        Boolean success = false;
        try {
            if (userRepository.findById(userId).isPresent()) {
                userRepository.deleteById(userId);
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User getUser(Long userId){
        return userRepository.findById(userId).get();
    }

}
