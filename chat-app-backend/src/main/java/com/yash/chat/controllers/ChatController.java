package com.yash.chat.controllers;

import com.yash.chat.entities.Room;
import com.yash.chat.payload.MessageRequest;
import com.yash.chat.entities.Message;
import com.yash.chat.repositories.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;


@Controller
@CrossOrigin("/http://localhost:3000")
public class ChatController {

    private RoomRepository roomRepository ;

    public ChatController ( RoomRepository roomRepository ){
        this.roomRepository = roomRepository ;
    }

    // for sending and recieving messages


    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId ,
            @RequestBody MessageRequest request
    ) throws Exception {


        Room room = roomRepository.findByRoomId(request.getRoomId()) ;
        Message message = new Message() ;
        message.setContent(request.getContent());
        message.getSender(request.getSender()) ;
        message.setTimestamp(LocalDateTime.now());


        if ( room != null ){
            room.getMessages().add(message) ;
            roomRepository.save(room) ;
        }

        else {
            throw new RuntimeException("Room not found") ;
        }

        return message ;

    }

}
