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

    public void joinRoom(Long roomId, Long userId){
        Room room = roomRepository.findById(roomId).get();
        room.getParticipants().add(userRepository.findById(userId).get());
    }

    public void deleteRoom(Long roomId){
        roomRepository.delete(roomRepository.findById(roomId).get());
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

    public List<Room> getHostingRooms(Long hostId){
        List<Room> rooms=upcomingRooms();
        List<Room> hostedRooms = new ArrayList<>();
        for(Room room:rooms){
            if(room.getHost().getUserId().equals(hostId)){
                hostedRooms.add(room);
            }
        }
        return hostedRooms;
    }

    public List<Room> getAttending(Long hostId){
        List<Room> rooms=upcomingRooms();
        List<Room> attendingRooms = new ArrayList<>();
        for (Room room:rooms){
            if(room.getParticipants().contains(userRepository.findById(hostId).get())){
                attendingRooms.add(room);
            }
        }
        return attendingRooms;
    }

    public void deleteScheduledRoom(Long roomId){
        roomRepository.delete(roomRepository.findById(roomId).get());
    }

    public void leaveRoom(Long roomId, Long hostId){
        roomRepository.findById(roomId).get().getParticipants().remove(userRepository.findById(hostId).get());
    }
}
