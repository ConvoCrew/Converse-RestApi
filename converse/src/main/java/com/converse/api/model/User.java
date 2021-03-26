package com.converse.api.model;


import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    //UUid ?
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
//    private Schedule schedule;
    private File profilePicture;
    private String password;
}
