package com.substring_chat.chat_app_backend.service;

import com.substring_chat.chat_app_backend.entities.Room;
import com.substring_chat.chat_app_backend.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService  {

    @Autowired
    private RoomRepository roomRepository;

    public Room getRoomById(String id){
        return roomRepository.findByRoomId(id);
    }


}
