package com.converse.api.controller;
import com.converse.api.model.RoomByUser;
import com.converse.api.model.Room;
import com.converse.api.model.User;
import com.converse.api.service.RoomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/room")
@Log4j2
public class RoomController {
    @Autowired
    RoomService roomService;

    @PostMapping("/create-room")
    public Room createRoom(@RequestBody RoomByUser createRoom) {
        return roomService.createRoom(createRoom.getRoom(), createRoom.getHostId());
    }

    @PostMapping("/create-private-room")
    public Room createPrivateRoom(@RequestBody RoomByUser createRoom, @Param("participants") List<User> participants) {
        return roomService.createPrivateRoom(createRoom.getRoom(), createRoom.getHostId(), participants);
    }

    @PostMapping("/schedule-room")
    //public Room scheduleRoom(@RequestBody RoomByUser createRoom, @Param ("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
    public Room scheduleRoom(@RequestBody RoomByUser createRoom, @Param ("dateStr") String dateStr) {
        log.info(dateStr);
        DateTimeFormatter formatter=DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTime=LocalDateTime.parse(dateStr,formatter);
        return roomService.scheduleRoom(createRoom.getRoom(), createRoom.getHostId(), dateTime);
    }

    @PostMapping("/create-scheduled-private-room")
    public Room createScheduledPrivateRoom(@RequestBody RoomByUser createRoom, @Param("dateStr") String dateStr) {
        log.info(dateStr);
        DateTimeFormatter formatter=DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTime=LocalDateTime.parse(dateStr,formatter);
        return roomService.createScheduledPrivateRoom(createRoom.getRoom(), createRoom.getHostId(), dateTime, createRoom.getRoom().getParticipants());
    }

    @PutMapping("/join-room")
    public Boolean joinRoom(@Param("roomId") Long roomId, @Param("userId") Long userId) {
        return roomService.joinRoom(roomId, userId);
    }

    //same endpoint can be hit for deleting a scheduled room
    @PostMapping("delete-room")
    public Boolean deleteRoom(@Param("roomId") Long roomId) {
        return roomService.deleteRoom(roomId);
    }

    @PostMapping("/live-rooms")
    public List<Room> liveRooms() {
        return roomService.liveRooms();
    }

    @PostMapping("/upcoming-rooms")
    public List<Room> upcomingRooms() {
        return roomService.upcomingRooms();
    }

    @PostMapping("/get-rooms-by-category")
    public List<Room> roomsByCategory(@Param("category") Room.Category category) {
        return roomService.getRoomsByCategory(category);
    }

    @PostMapping("hosting-rooms")
    public List<Room> hostingRooms(@Param("hostId") Long hostId) {
        return roomService.getHostingRooms(hostId);
    }

    @PostMapping("attending-rooms")
    public List<Room> attendingRooms(@Param("hostId") Long hostId) {
        return roomService.getAttending(hostId);
    }

    @PostMapping("leave-room")
    public Boolean leaveRoom(@Param("roomId") Long roomId, @Param("roomId") Long hostId) {
        return roomService.leaveRoom(roomId, hostId);
    }

    @GetMapping("get-participants")
    public List<User> getParticipants(@Param("roomId") Long roomId) {
        return roomService.getRoom(roomId).getParticipants();
    }

}