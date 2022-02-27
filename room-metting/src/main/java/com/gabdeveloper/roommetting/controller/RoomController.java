package com.gabdeveloper.roommetting.controller;

import java.util.List;

import javax.validation.Valid;

import com.gabdeveloper.roommetting.exception.ResourceNotFoundException;
import com.gabdeveloper.roommetting.model.Room;
import com.gabdeveloper.roommetting.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1")
public class RoomController {
    
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(value="/rooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping(value="/rooms/{id}")
    public ResponseEntity<Room> getRoomsById(@PathVariable Long roomId) throws ResourceNotFoundException{
        Room room = roomRepository.findById(roomId).orElseThrow(
            () -> new ResourceNotFoundException("Room not found:: "+ roomId));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping(value="/rooms")
    public Room createRoom(@Valid @RequestBody Room room){
        return roomRepository.save(room);
    }

    @PutMapping(value="/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long roomId,@Valid @RequestBody Room room)throws ResourceNotFoundException{
        Room roomFind = roomRepository.findById(roomId).orElseThrow(
            () -> new ResourceNotFoundException("Room not found:: "+ roomId));
        roomFind.setName(room.getName());
        roomFind.setDate(room.getDate());
        roomFind.setStartHour(room.getStartHour());
        roomFind.setEndHour(room.getEndHour());
        final Room updateRoom = roomRepository.save(roomFind);
        return ResponseEntity.ok().body(updateRoom);
    }
    
    @DeleteMapping(value="/rooms/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable Long roomId) throws ResourceNotFoundException{
        Room roomFind = roomRepository.findById(roomId).orElseThrow(
            () -> new ResourceNotFoundException("Room not found:: "+ roomId));
        roomRepository.delete(roomFind);
        return ResponseEntity.ok().body("Item deletado com sucesso!");
    }

}