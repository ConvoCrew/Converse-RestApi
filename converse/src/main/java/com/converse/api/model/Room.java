package com.converse.api.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString
@Embeddable
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roomId;
    public Status status;
    public String title;
    private String topic;
    public int numOfParticipants;
    //true if public false is private
    boolean Accessible=true;
    @ManyToMany
    private List<User> participants;
    @OneToOne
    private User host;
    public Date liveDate;

    public enum Status{LIVE, UPCOMING}
    public enum Category{MATHEMATICS, }

}