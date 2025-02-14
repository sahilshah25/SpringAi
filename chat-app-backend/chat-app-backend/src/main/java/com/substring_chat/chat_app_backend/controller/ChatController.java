package com.substring_chat.chat_app_backend.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.substring_chat.chat_app_backend.entities.Message;
import com.substring_chat.chat_app_backend.entities.Room;
import com.substring_chat.chat_app_backend.playload.MessageRequest;
import com.substring_chat.chat_app_backend.repositories.RoomRepository;


@Controller

@CrossOrigin("http://localhost:5173")
public class ChatController {
    

    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //for sending and recieving messages
    @MessageMapping("/app/sendMessage/{roomId}")//send messages
    @SendTo("/topic/room/{roomId}")//subscribe
    public Message sendMessage(
        @DestinationVariable String roomId,
      @RequestBody MessageRequest request
      

    ) {
       Room room= roomRepository.findByRoomId((request.getRoomId()));

     Message message=new Message();
     message.setContent(request.getContent());
     message.setSender(request.getSender());
     message.setTimeStamp(LocalDateTime.now());

     if(room!=null){
        room.getMessages().add(message);
        roomRepository.save(room);
     }else{
        throw new RuntimeException("room not found");
     }
     return message;




    }


}
