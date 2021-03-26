package com.converse.api.model;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Room {
    public Status status;
    public String title;
    private String topic;
    public int numOfParticipants;
    //true if public false is private
    boolean Accessible=true;
    private List<User> participants;
    private User host;
    public Date liveDate;

    public enum Status{LIVE, UPCOMING}
    public enum Category{MATHEMATICS, }

}
