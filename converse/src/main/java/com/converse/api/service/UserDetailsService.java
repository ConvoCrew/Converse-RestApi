package com.converse.api.service;

import com.converse.api.model.Room;
import com.converse.api.model.User;
import com.converse.api.repository.RoomRepository;
import com.converse.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;

    public List<User> getUsersInRoom(Long roomId) {
        Room room = roomRepository.findById(roomId).get();
        List<User> users = room.getParticipants();
        return users;
    }
}
