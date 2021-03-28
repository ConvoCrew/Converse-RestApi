package com.converse.api.controller;

import com.converse.api.model.Id;
import com.converse.api.model.Test;
import com.converse.api.model.User;
import com.converse.api.repository.Tests;
import com.converse.api.service.UserDetailsService;
import com.converse.api.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
public class UserController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    UserService userService;
    @Autowired
    Tests testRepository;

    @ResponseBody
    @GetMapping("/test/{test}")
    public Test createTest(@PathVariable(name="test") Integer test) {
        log.info(test);
        return null;
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update-user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@Param("userId") Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.status(200).body("deletion successful");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("deletion unsuccessful");
        }
    }

    @PostMapping("/get-user-by-email")
    public User getUserByEmail(@Param("email")String email){
        return userService.getUserByEmail(email);
    }
    @PostMapping("/get-user")
    public User getUser(@RequestBody Id userId) {
        log.info(userId);
        return userService.getUser(Long.valueOf(userId.getId()));
    }
}

