package com.yash.chat.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String sender ;
    private String content ;
    private LocalDateTime timestamp ;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now() ;
    }

    public void getSender(String sender) {
        this.sender = sender ;
    }
}
