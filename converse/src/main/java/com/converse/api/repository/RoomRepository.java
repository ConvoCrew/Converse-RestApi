package com.converse.api.repository;

import com.converse.api.model.Room;
import com.converse.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
//Room findByHost(User host);
}
