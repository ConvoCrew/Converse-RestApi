package com.converse.api.service;
import com.converse.api.model.Room;
import com.converse.api.model.RoomByUser;
import com.converse.api.model.User;
import com.converse.api.repository.RoomRepository;
import com.converse.api.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;

    public Room createRoom(Room room, Long hostId) {

        room.setHost(userRepository.findById(hostId).get().getUserId());
        room.setLiveDate(LocalDateTime.now());
        return roomRepository.save(room);
    }

    public Room createPrivateRoom(Room room, Long hostId, List<User> userList) {

        room.setHost(userRepository.findById(hostId).get().getUserId());
        room.setLiveDate(LocalDateTime.now());
       // room.setAccessible(false);
        room.setParticipants(userList);
        return roomRepository.save(room);
    }

    public Room scheduleRoom(Room room, Long hostId, LocalDateTime dateTime) {
        room.setHost(userRepository.findById(hostId).get().getUserId());
        room.setLiveDate(dateTime);
        return roomRepository.save(room);
    }


    public Room createScheduledPrivateRoom(Room room, Long hostId, LocalDateTime dateTime, List<User> userList) {

        room.setHost(userRepository.findById(hostId).get().getUserId());
        room.setLiveDate(dateTime);
        //room.setAccessible(false);
        room.setParticipants(userList);
        return roomRepository.save(room);
    }


    public Boolean joinRoom(Long roomId, Long userId) {
        Boolean success = false;
        if (roomRepository.findById(roomId).isPresent()) {
            Room room = roomRepository.findById(roomId).get();
            if (room.getParticipants().size() < room.getMaxNumOfParticipants()) {
                try {
                    room.getParticipants().add(userRepository.findById(userId).get());
                    roomRepository.save(room);
                    success = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
            return success;

    }

    public Boolean deleteRoom(Long roomId) {
        Boolean success = false;
        if (roomRepository.findById(roomId).isPresent()) {
            roomRepository.delete(roomRepository.findById(roomId).get());
            success = true;
        }
        return success;

    }

    public List<Room> liveRooms() {
        List<Room> liveRooms = new ArrayList<>();
       for (Room room : roomRepository.findAll()) {
            log.info(room.getLiveDate());
            if(room.getLiveDate()!=null) {
            } else if (room.getLiveDate().isBefore(LocalDateTime.now())){
                log.info("found");
                liveRooms.add(room);
            }
        }
        return liveRooms;

    }

    public List<Room> upcomingRooms() {
        List<Room> upcomingRooms = new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            if (room.getLiveDate().isAfter(LocalDateTime.now())) {
                upcomingRooms.add(room);
            }
        }
        return upcomingRooms;
    }

    public List<Room> getHostingRooms(Long hostId) {
        List<Room> rooms = upcomingRooms();
        List<Room> hostedRooms = new ArrayList<>();
        for (Room room : rooms) {
           // if (room.getHost().getUserId().equals(hostId)) {
                if(room.getHost().equals(hostId)){
                hostedRooms.add(room);
            }
        }
        return hostedRooms;

    }


    public List<Room> getAttending(Long hostId) {
        List<Room> rooms = upcomingRooms();
        List<Room> attendingRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getParticipants().contains(userRepository.findById(hostId).get())) {
                attendingRooms.add(room);

            }
        }
        return attendingRooms;

    }




//    public Boolean deleteScheduledRoom(Long roomId){
//        Boolean success=false;
//        if (roomRepository.findById(roomId).isPresent())
//        {
//            roomRepository.delete(roomRepository.findById(roomId).get());
//            success=true;
//        }
//        return success;
//    }

    public Boolean leaveRoom (Long roomId, Long userId){
        Boolean success = false;
        if (roomRepository.findById(roomId).get().getParticipants().contains(userRepository.findById(userId))) {
            roomRepository.findById(roomId).get().getParticipants().remove(userRepository.findById(userId).get());
            success = true;
        }
        return success;
    }

    public Room getRoom (Long roomId){
        return roomRepository.findById(roomId).get();
    }


    public List<Room> getRoomsByCategory (Room.Category category){
        return roomRepository.findByCategory(category);
    }
}


