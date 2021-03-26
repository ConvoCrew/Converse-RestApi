package com.converse.api.controller;


import com.converse.api.model.RoomByUser;
import com.converse.api.model.Room;
import com.converse.api.service.RoomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@Log4j2
public class RoomController {
    @Autowired
    RoomService roomService;

    @PostMapping("/create-room")
    public Room createRoom(@RequestBody RoomByUser createRoom){
     return roomService.createRoom(createRoom.getRoom(), createRoom.getHostId());
    }

    @PostMapping("/join-room")
    public void joinRoom(@RequestBody Long userId){
//        return roomService.createRoom(createRoom, createRoom.getHostId());
    }

    @PostMapping("/live-rooms")
    public List<Room> liveRooms(){
        return roomService.liveRooms();
    }

    @PostMapping("/upcoming-rooms")
    public List<Room> upcomingRooms(){
        return roomService.upcomingRooms();
    }
}
