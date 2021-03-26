package com.converse.api.model;


import lombok.Data;

import javax.persistence.*;
import java.io.File;
import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    //UUid ?
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    public String firstName;
    public String lastName;
    private String email;
    @Embedded
    private Schedule schedule;
    private File profilePicture;
    private String password;


}