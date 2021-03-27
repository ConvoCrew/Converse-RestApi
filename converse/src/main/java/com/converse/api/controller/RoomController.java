package com.converse.api.controller;
import com.converse.api.model.RoomByUser;
import com.converse.api.model.Room;
import com.converse.api.model.User;
import com.converse.api.service.RoomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
public class RoomController {
    @Autowired
    RoomService roomService;

    @PostMapping("/create-room")
    public Room createRoom(@RequestBody RoomByUser createRoom){
     return roomService.createRoom(createRoom.getRoom(), createRoom.getHostId());
    }

    @PostMapping("/schedule-room")
    public Room scheduleRoom(@RequestBody RoomByUser createRoom, @Param("date") LocalDateTime date){
        return roomService.scheduleRoom(createRoom.getRoom(), createRoom.getHostId(), date);
    }

    @PostMapping("/join-room")
    public void joinRoom(@Param("roomId") Long roomId, @Param("userId") Long userId){
        roomService.joinRoom(roomId, userId);
    }

    @PostMapping("delete-room")
    public void deleteRoom(@Param("roomId") Long roomId){
        roomService.deleteRoom(roomId);
    }

    @PostMapping("/live-rooms")
    public List<Room> liveRooms(){
        return roomService.liveRooms();
    }

    @PostMapping("/upcoming-rooms")
    public List<Room> upcomingRooms(){
        return roomService.upcomingRooms();
    }

    @PostMapping("hosting-rooms")
    public List<Room> hostingRooms(@Param("hostId") Long hostId){
        return roomService.getHostingRooms(hostId);
    }

    @PostMapping("attending-rooms")
    public List<Room> attendingRooms(@Param("hostId") Long hostId){
        return roomService.getAttending(hostId);
    }

    @PostMapping("delete-scheduled-room")
    public void deleteScheduledRun(@Param("roomId") Long roomId){
        roomService.deleteScheduledRoom(roomId);
    }


    @PostMapping("leave-room")
    public void leaveRoom(@Param("roomId")Long roomId, @Param("roomId") Long hostId){
        roomService.leaveRoom(roomId, hostId);
    }
    @PostMapping("get-participants")
    public List<User> getParticipants(@Param("roomId")Long roomId){
        return roomService.getRoom(roomId).getParticipants();
    }

}