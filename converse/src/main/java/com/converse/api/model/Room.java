package com.converse.api.model;


import lombok.*;

import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Embeddable
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roomId;
    private Status status;
    private String title;
    private String topic;
    private int maxNumOfParticipants;
    //true if public false is private
    boolean Accessible=true;
    @ManyToMany
    private List<User> participants;
    @OneToOne
    private User host;
    private LocalDateTime liveDate;

    private enum Status{LIVE, UPCOMING}
    private enum Category{MATHEMATICS, }

}