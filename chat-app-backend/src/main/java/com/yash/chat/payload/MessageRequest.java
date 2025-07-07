package com.yash.chat.payload;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String content ;
    private String sender ;
    private String roomId ;

    private LocalDateTime messageTime ;
}
