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
@Entity(name = "room")
@Table(name = "rooms")
@ToString
@Embeddable
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private Status status;
    private String title;
    private String topic;
    private int maxNumOfParticipants;
    //true if public false if private
    boolean accessible = true;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<User> participants;
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private User host;
    private LocalDateTime liveDate;
    private Category category;
    private Tag tag;

    private enum Status {LIVE, UPCOMING}

    public enum Category {MATHEMATICS, SCIENCE, MUSIC, FOREIGN_LANGUAGE, DRAMATIC_ARTS}

    private enum Tag {STUDY_ROOM, DISCUSSION}
}