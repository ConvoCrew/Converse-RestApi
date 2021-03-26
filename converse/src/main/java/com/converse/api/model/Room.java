package com.converse.api.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Status status;
    private String title;
    private String topic;
    private int maxNumOfParticipants;
    //true if public false is private
    boolean Accessible=true;
    private List<User> participants;
    private User host;
    private LocalDateTime liveDate;

    private enum Status{LIVE, UPCOMING}
    private enum Category{MATHEMATICS, }

}
