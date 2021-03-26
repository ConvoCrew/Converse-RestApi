package com.converse.api.model;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.util.UUID;

@Data
public class User {
    @Id
    //UUid ?
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    public String firstName;
    public String lastName;
    private String email;
    private Schedule schedule;
    private File profilePicture;
    private String password;


}
