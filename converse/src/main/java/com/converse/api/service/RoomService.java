package com.converse.api.service;


import com.converse.api.model.Room;
import com.converse.api.model.RoomByUser;
import com.converse.api.repository.RoomRepository;
import com.converse.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;

    public Room createRoom(Room room, Long hostId){
        room.setHost(userRepository.findById(hostId).get());
        room.setLiveDate(LocalDateTime.now());
        return roomRepository.save(room);
    }

    public Room scheduleRoom(Room room, Long hostId, LocalDateTime dateTime){
        room.setHost(userRepository.findById(hostId).get());
        room.setLiveDate(dateTime);
        return roomRepository.save(room);
    }

    public void joinRoom(Room room, Long userId){
        room.getParticipants().add(userRepository.findById(userId).get());
    }

    public List<Room> liveRooms(){
        List<Room> liveRooms = new ArrayList<>();
        for(Room room:roomRepository.findAll()){
            if(room.getLiveDate().isBefore(LocalDateTime.now())){
                liveRooms.add(room);
            }
        }
        return liveRooms;
    }

    public List<Room> upcomingRooms(){
        List<Room> upcomingRooms = new ArrayList<>();
        for(Room room:roomRepository.findAll()){
            if(room.getLiveDate().isAfter(LocalDateTime.now())){
                upcomingRooms.add(room);
            }
        }
        return upcomingRooms;
    }

//    public List<Room> hostingRooms(){
//
//    }
//
//    public List<Room> attendingRooms(){
//
//    }
}
