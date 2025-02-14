package com.substring_chat.chat_app_backend.playload;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MessageRequest {

    private String content;
    private String sender;
    private String roomId;
    

}
