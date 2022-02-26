package com.gabdeveloper.roommetting.repository;

import com.gabdeveloper.roommetting.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    
}