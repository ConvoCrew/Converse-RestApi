package com.converse.api.service;


import com.converse.api.model.Room;
import com.converse.api.repository.RoomRepository;
import com.converse.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;
    public Room createRoom(Room room, Long hostId){
        //room.setHost(userRepository.findById(hostId).get());
        //return roomRepository.save(room);
          return null;
    }
}
