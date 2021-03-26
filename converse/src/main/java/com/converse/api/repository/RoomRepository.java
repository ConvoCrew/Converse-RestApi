package com.converse.api.repository;

import com.converse.api.model.Room;
import com.converse.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
//Room findByHost(User host);
}
